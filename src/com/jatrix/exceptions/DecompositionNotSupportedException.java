package com.jatrix.exceptions;

/**
 * Thrown exception when user sets not a square matrix
 */

public class DecompositionNotSupportedException extends RuntimeException {
    public DecompositionNotSupportedException(String s) {
        super(s);
    }
}
