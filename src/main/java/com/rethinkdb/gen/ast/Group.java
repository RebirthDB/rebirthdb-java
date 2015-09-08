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



public class Group extends ReqlExpr {


    public Group(Object arg) {
        this(new Arguments(arg), null);
    }
    public Group(Arguments args){
        this(args, null);
    }
    public Group(Arguments args, OptArgs optargs) {
        this(TermType.GROUP, args, optargs);
    }
    protected Group(TermType termType, Arguments args, OptArgs optargs){
        super(termType, args, optargs);
    }
public Group optArg(String optname, Object value) {
    OptArgs newOptargs = OptArgs.fromMap(optargs).with(optname, value);
    return new Group(args, newOptargs);
}

}
