package com.fullcycle.admin.catalogo.domain.exceptions;

public class NoStacktraceException extends RuntimeException {

    public NoStacktraceException(final String message) {
        this(message, null);
    }

    public NoStacktraceException(final String message, final Throwable cause) {
        // não vai ficar enchendo a stacktrace, isso é uma parada muito custosa da jvm
        super(message, cause, true, false);
    }
}
