package com.jatrix.decompositions;

import com.jatrix.core.Matrix;
import com.jatrix.exceptions.MatrixSizeException;


/**
 * A class for performing a LU factorization (decomposition) of a {@link Matrix} object.
 */
public class LUDecomposition {
    private Matrix A;
    private Matrix L;
    private Matrix U;
    private Matrix P;
    private LUPDecomposition lup;


    /**
     * Constructs {@link LUDecomposition} object, received a {@link Matrix} object to
     * decompose a matrix into LU decomposition method.
     * @param A Matrix object to LU factorization.
     * @throws MatrixSizeException if a <code>A</code> matrix is non-square.
     */
    public LUDecomposition(Matrix A) {
        if (!A.isSquare())
            throw new MatrixSizeException("Invalid matrix to LU decomposition: matrix must be square.\nFounded: " +
                    A.getRowDimension() + " x " + A.getColumnDimension());
        decompose(A);
    }

    private void decompose(Matrix A) {
        int size = A.getRowDimension();
        L = new Matrix(size).identity();
        U = A.clone();

        for (int i = 0; i < size - 1; i++) {
            for (int k = i+1; k < size; k++) {
                double den = U.get(i, i);
                if (den == 0) {
                    lup = new LUPDecomposition(A);
                    this.U = lup.getU();
                    this.L = lup.getL();
                    this.P = lup.getP();
                    return;
                }
                double div = U.get(k,i)/den;
                L.set(k, i, div);
                for (int j = i; j < size; j++) {
                    U.set(k, j, U.get(k,j) - U.get(i,j)*div);
                }
            }
        }
    }


    /**
     * Gets a lower-triangular matrix.
     * @return Matrix object
     */
    public Matrix getL() {
        return L;
    }


    /**
     * Gets an upper-triangular matrix.
     * @return Matrix object
     */
    public Matrix getU() {
        return U;
    }


    /**
     * Gets a permutation matrix.
     * @return Matrix object
     */
    public Matrix getP() {
        return P;
    }


    /**
     * Gets determinant of a Matrix object.
     * @return double value, representing determinant of Matrix object.
     */
    public double det() {
        if (lup != null) return lup.det();
        double det = 1;
        for (int i = 0; i < U.getRowDimension(); i++) {
            det *= U.get(i ,i);
        }
        return det;
    }
}
