package com.jatrix.exceptions;

/**
 * An exception class for used when {@link com.jatrix.core.Matrix} object has inappropriate dimensions.
 * @see com.jatrix.core.Matrix
 */
public class MatrixSizeException extends RuntimeException {
    public MatrixSizeException(String string) {
        super(string);
    }   
}
