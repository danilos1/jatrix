package com.jatrix.exceptions;

/**
 * An exception class for used when {@link com.jatrix.core.Matrix} object is singular, means that determinant is equaled to
 * zero.
 * @see com.jatrix.core.Matrix
 */
public class MatrixSingularException extends RuntimeException {
    public MatrixSingularException(String message) {
        super(message);
    }
}
