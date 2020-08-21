package com.jatrix.exceptions;

/**
 * Thrown exception when the determinant is equal zero
 */

public class MatrixSingularException extends RuntimeException {
    public MatrixSingularException(String message) {
        super(message);
    }
}
