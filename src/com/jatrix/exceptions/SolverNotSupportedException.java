package com.jatrix.exceptions;

/**
 * Thrown when matrix is not square
 */

public class SolverNotSupportedException extends RuntimeException {
    public SolverNotSupportedException(String message) {
        super(message);
    }
}
