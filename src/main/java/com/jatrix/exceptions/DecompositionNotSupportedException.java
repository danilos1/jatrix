package com.jatrix.exceptions;

/**
 * An exception class for used when some decomposition is not supported by some reasons.
 * @see com.jatrix.decompositions.CholeskyDecomposition
 */
public class DecompositionNotSupportedException extends RuntimeException {
    public DecompositionNotSupportedException(String s) {
        super(s);
    }
}
