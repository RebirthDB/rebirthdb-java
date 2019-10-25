package com.rethinkdb.ast;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.gen.ast.*;
import com.rethinkdb.gen.exc.ReqlDriverCompileError;
import com.rethinkdb.gen.exc.ReqlDriverError;
import com.rethinkdb.model.Arguments;
import com.rethinkdb.model.MapObject;
import com.rethinkdb.model.ReqlLambda;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;


public class Util {
    private Util() {}

    /**
     * Coerces objects from their native type to ReqlAst
     *
     * @param val val
     * @return ReqlAst
     */
    public static ReqlAst toReqlAst(Object val) {
        return toReqlAst(val, 100);
    }

    public static ReqlExpr toReqlExpr(Object val) {
        ReqlAst converted = toReqlAst(val);
        if (converted instanceof ReqlExpr) {
            return (ReqlExpr) converted;
        } else {
            throw new ReqlDriverError("Cannot convert %s to ReqlExpr", val);
        }
    }

    @SuppressWarnings("unchecked")
    private static ReqlAst toReqlAst(Object val, int remainingDepth) {
        if (remainingDepth <= 0) {
            throw new ReqlDriverCompileError("Recursion limit reached converting to ReqlAst");
        }
        if (val instanceof ReqlAst) {
            return (ReqlAst) val;
        }

        if (val instanceof Object[]) {
            Arguments innerValues = new Arguments();
            for (Object innerValue : (Object[]) val) {
                innerValues.add(toReqlAst(innerValue, remainingDepth - 1));
            }
            return new MakeArray(innerValues, null);
        }

        if (val instanceof List) {
            Arguments innerValues = new Arguments();
            for (java.lang.Object innerValue : (List) val) {
                innerValues.add(toReqlAst(innerValue, remainingDepth - 1));
            }
            return new MakeArray(innerValues, null);
        }

        if (val instanceof Map) {
            Map<String, ReqlAst> obj = new MapObject<>();
            ((Map<Object, Object>) val).forEach((key, value) -> {
                if (!(key instanceof String)) {
                    throw new ReqlDriverCompileError("Object keys can only be strings");
                }
                obj.put((String) key, toReqlAst(value));
            });
            return MakeObj.fromMap(obj);
        }

        if (val instanceof ReqlLambda) {
            return Func.fromLambda((ReqlLambda) val);
        }

        final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");

        if (val instanceof LocalDateTime) {
            ZoneId zid = ZoneId.systemDefault();
            DateTimeFormatter fmt2 = fmt.withZone(zid);
            return Iso8601.fromString(((LocalDateTime) val).format(fmt2));
        }
        if (val instanceof ZonedDateTime) {
            return Iso8601.fromString(((ZonedDateTime) val).format(fmt));
        }
        if (val instanceof OffsetDateTime) {
            return Iso8601.fromString(((OffsetDateTime) val).format(fmt));
        }

        if (val instanceof Integer) {
            return new Datum(val);
        }

        if (val instanceof Number) {
            return new Datum(val);
        }

        if (val instanceof Boolean) {
            return new Datum(val);
        }

        if (val instanceof String) {
            return new Datum(val);
        }

        if (val == null) {
            return new Datum(null);
        }

        if (val.getClass().isEnum()) {
            return new Datum(val.toString());
        }

        // val is a non-null POJO, let's use jackson
        return toReqlAst(RethinkDB.getPOJOMapper().convertValue(val, Map.class));
    }
}
