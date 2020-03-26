// Autogenerated by metajava.py.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../../../../templates/AstSubclass.java

package com.rethinkdb.gen.ast;

import com.rethinkdb.gen.proto.TermType;
import com.rethinkdb.gen.exc.ReqlDriverError;
import com.rethinkdb.model.Arguments;
import com.rethinkdb.model.OptArgs;
import com.rethinkdb.ast.ReqlAst;

public class Slice extends ReqlExpr {

    public Slice(Object arg) {
        this(new Arguments(arg), null);
    }
    public Slice(Arguments args) {
        this(args, null);
    }
    public Slice(Arguments args, OptArgs optargs) {
        super(TermType.SLICE, args, optargs);
    }
    public Slice optArg(String optname, Object value) {
        OptArgs newOptargs = OptArgs.fromMap(optargs).with(optname, value);
        return new Slice(args, newOptargs);
    }
    public Slice optArg(String optname, ReqlFunction0 value) {
        OptArgs newOptargs = OptArgs.fromMap(optargs).with(optname, value);
        return new Slice(args, newOptargs);
    }
    public Slice optArg(String optname, ReqlFunction1 value) {
        OptArgs newOptargs = OptArgs.fromMap(optargs).with(optname, value);
        return new Slice(args, newOptargs);
    }
    public Slice optArg(String optname, ReqlFunction2 value) {
        OptArgs newOptargs = OptArgs.fromMap(optargs).with(optname, value);
        return new Slice(args, newOptargs);
    }
    public Slice optArg(String optname, ReqlFunction3 value) {
        OptArgs newOptargs = OptArgs.fromMap(optargs).with(optname, value);
        return new Slice(args, newOptargs);
    }
    public Slice optArg(String optname, ReqlFunction4 value) {
        OptArgs newOptargs = OptArgs.fromMap(optargs).with(optname, value);
        return new Slice(args, newOptargs);
    }

}
