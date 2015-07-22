// Autogenerated by metajava.py.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../../../../templates/AstSubclass.java
package com.rethinkdb.ast.gen;

import com.rethinkdb.ast.helper.Arguments;
import com.rethinkdb.ast.helper.OptArgs;
import com.rethinkdb.ast.RqlAst;
import com.rethinkdb.proto.TermType;
import java.util.*;



public class MakeArray extends RqlQuery {


    public MakeArray(java.lang.Object arg) {
        this(new Arguments(arg), null);
    }
    public MakeArray(Arguments args, OptArgs optargs) {
        this(null, args, optargs);
    }
    public MakeArray(RqlAst prev, Arguments args, OptArgs optargs) {
        this(prev, TermType.MAKE_ARRAY, args, optargs);
    }
    protected MakeArray(RqlAst previous, TermType termType, Arguments args, OptArgs optargs){
        super(previous, termType, args, optargs);
    }


    /* Static factories */
    public static MakeArray fromArgs(Object... args){
        return new MakeArray(new Arguments(args), null);
    }


}
