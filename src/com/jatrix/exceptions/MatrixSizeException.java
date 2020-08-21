package com.jatrix.exceptions;

/**
 *
 * @author Solovjov D. & Timochko D.
 * This exception is used for indicating if a user set unequal column sizes
 */

public class MatrixSizeException extends RuntimeException {
    public MatrixSizeException(String string) {
        super(string);
    }   
}
