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



public class Random extends ReqlExpr {


    public Random(Object arg) {
        this(new Arguments(arg), null);
    }
    public Random(Arguments args){
        this(args, null);
    }
    public Random(Arguments args, OptArgs optargs) {
        this(TermType.RANDOM, args, optargs);
    }
    protected Random(TermType termType, Arguments args, OptArgs optargs){
        super(termType, args, optargs);
    }
public Random optArg(String optname, Object value) {
    OptArgs newOptargs = OptArgs.fromMap(optargs).with(optname, value);
    return new Random(args, newOptargs);
}

}
