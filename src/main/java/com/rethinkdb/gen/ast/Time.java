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

public class Time extends ReqlExpr {

    public Time(Object arg) {
        this(new Arguments(arg), null);
    }
    public Time(Arguments args) {
        this(args, null);
    }
    public Time(Arguments args, OptArgs optargs) {
        super(TermType.TIME, args, optargs);
    }

}
