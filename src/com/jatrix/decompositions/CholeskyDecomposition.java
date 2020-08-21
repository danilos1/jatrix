package com.jatrix.decompositions;

import com.jatrix.core.Matrix;
import com.jatrix.exceptions.DecompositionNotSupportedException;
import com.jatrix.exceptions.MatrixSizeException;

/**
 * A class for performing a Cholesky factorization (decomposition) of a {@link Matrix} object.
 */
public class CholeskyDecomposition {
    private Matrix L;
    private Matrix Lt;
    private int sign;

    /**
     * Constructs {@link CholeskyDecomposition} object, received a {@link Matrix} object to
     * decompose a matrix into Cholesky decomposition method.
     * @param A Matrix object to Cholesky factorization.
     * @throws MatrixSizeException if a <code>A</code> matrix is non-square.
     * @throws DecompositionNotSupportedException if a <code>A</code> matrix does not support the Cholesky factorization
     * or if a matrix is defined as non-positive.
     */
    public CholeskyDecomposition(Matrix A) {
        if (!A.isSquare())
            throw new MatrixSizeException("Invalid matrix to LU decomposition: matrix must be square.\nFounded: " +
                    A.getRowDimension() + " by " + A.getColumnDimension());
        decompose(A);
    }

    private void decompose(Matrix A) {
        if (!A.equals(A.getTranspose())) {
            throw new DecompositionNotSupportedException("Matrix does not support a Cholesky decompostition, " +
                    "since matrix doesn't equal to transposed itself");
        }

        for (int i = 0; i < A.getRowDimension(); i++) {
            if (A.get(i,i) == 0) {
                throw new DecompositionNotSupportedException("Matrix is defined as non-positive");
            }
        }

        int size = A.getRowDimension();
        L = new Matrix(size).identity();
        Lt = new Matrix(size);
        sign = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i+1; j++) {
                double sum = 0.0;
                if (j == i) {
                    for (int k = 0; k < j; k++) {
                        sum += L.get(j, k) * L.get(j, k);
                    }
                    double dif = A.get(j, j) - sum;
                    if (dif < 0) throw new DecompositionNotSupportedException("Matrix is non-positive") ;
                    L.set(j, j, Math.sqrt(dif));
                }
                else {
                    for (int k = 0; k < j; k++) {
                        sum += L.get(i, k) * L.get(j, k);
                    }
                    L.set(i, j, (A.get(i, j) - sum)/L.get(j , j));
                }
            }
        }
        Lt = L.getTranspose();
    }

    /**
     * Gets a lower-triangular matrix.
     * @return Matrix object
     */
    public Matrix getL() {
        return L;
    }

    /**
     * Gets a lower-triangular transposed matrix
     * @return Matrix object
     */
    public Matrix getLt() {
        return Lt;
    }

    /**
     * Gets determinant of a Matrix object.
     * @return double value, representing determinant of Matrix object.
     */
    public double det() {
        double det = 1;
        for (int i = 0; i < L.getRowDimension(); i++) {
            double d = L.get(i, i);
            det *= d*d;
        }
        return (sign & 0b1) == 0 ? det : -det;
    }
}
