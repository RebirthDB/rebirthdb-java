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



public class DeleteAt extends ReqlExpr {


    public DeleteAt(Object arg) {
        this(new Arguments(arg), null);
    }
    public DeleteAt(Arguments args){
        this(args, null);
    }
    public DeleteAt(Arguments args, OptArgs optargs) {
        this(TermType.DELETE_AT, args, optargs);
    }
    protected DeleteAt(TermType termType, Arguments args, OptArgs optargs){
        super(termType, args, optargs);
    }

}
