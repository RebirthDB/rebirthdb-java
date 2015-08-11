// Autogenerated by metajava.py.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../../templates/Exception.java
package com.rethinkdb;

import java.util.Optional;
import com.rethinkdb.ast.ReqlAst;
import com.rethinkdb.model.Backtrace;

public class ReqlAuthError extends ReqlDriverError {

    Optional<Backtrace> backtrace = Optional.empty();
    Optional<ReqlAst> term = Optional.empty();

    public ReqlAuthError() {
    }

    public ReqlAuthError(String message) {
        super(message);
    }

    public ReqlAuthError(String format, Object... args) {
        super(String.format(format, args));
    }

    public ReqlAuthError(String message, Throwable cause) {
        super(message, cause);
    }

    public ReqlAuthError(Throwable cause) {
        super(cause);
    }

    public ReqlAuthError(String msg, ReqlAst term, Backtrace bt) {
        super(msg);
        this.backtrace = Optional.ofNullable(bt);
        this.term = Optional.ofNullable(term);
    }

    public ReqlAuthError setBacktrace(Backtrace backtrace) {
        this.backtrace = Optional.ofNullable(backtrace);
        return this;
    }

    public Optional<Backtrace> getBacktrace() {
        return backtrace;
    }

    public ReqlAuthError setTerm(ReqlAst term) {
        this.term = Optional.ofNullable(term);
        return this;
    }

    public Optional<ReqlAst> getTerm() {
        return this.term;
    }
}
