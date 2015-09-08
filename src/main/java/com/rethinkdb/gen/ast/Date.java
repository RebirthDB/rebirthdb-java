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



public class Date extends ReqlExpr {


    public Date(Object arg) {
        this(new Arguments(arg), null);
    }
    public Date(Arguments args){
        this(args, null);
    }
    public Date(Arguments args, OptArgs optargs) {
        this(TermType.DATE, args, optargs);
    }
    protected Date(TermType termType, Arguments args, OptArgs optargs){
        super(termType, args, optargs);
    }

}
