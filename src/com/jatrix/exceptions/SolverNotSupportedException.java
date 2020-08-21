package com.jatrix.exceptions;

/**
 * An exception class for used when some solver method is not supported by some reasons.
 * @see com.jatrix.solvers.CramerSolver
 */
public class SolverNotSupportedException extends RuntimeException {
    public SolverNotSupportedException(String message) {
        super(message);
    }
}
