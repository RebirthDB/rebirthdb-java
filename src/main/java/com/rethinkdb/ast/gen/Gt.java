// Autogenerated by convert_protofile.py on 2015-05-04.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../../../../templates/AstSubclass.java
package com.rethinkdb.ast.gen;

import com.rethinkdb.ast.helper.Arguments;
import com.rethinkdb.ast.helper.OptArgs;
import com.rethinkdb.ast.RqlAst;
import com.rethinkdb.proto.TermType;
import java.util.*;

public class Gt extends RqlQuery {

    public Gt(RqlAst prev, Arguments args, OptArgs optargs) {
        this(prev, TermType.GT, args, optargs);
    }
    protected Gt(RqlAst previous, TermType termType, Arguments args, OptArgs optargs){
        super(previous, termType, args, optargs);
    }
    /* Query level terms */
}
