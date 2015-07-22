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



public class Pluck extends RqlQuery {


    public Pluck(java.lang.Object arg) {
        this(new Arguments(arg), null);
    }
    public Pluck(Arguments args, OptArgs optargs) {
        this(null, args, optargs);
    }
    public Pluck(RqlAst prev, Arguments args, OptArgs optargs) {
        this(prev, TermType.PLUCK, args, optargs);
    }
    protected Pluck(RqlAst previous, TermType termType, Arguments args, OptArgs optargs){
        super(previous, termType, args, optargs);
    }


    /* Static factories */
    public static Pluck fromArgs(Object... args){
        return new Pluck(new Arguments(args), null);
    }


}
