package main.java.com.jatrix.decomposition;

import main.java.com.jatrix.Matrix;
import main.java.com.jatrix.exceptions.MatrixSizeException;

public class LUDecomposition {
    private Matrix A;
    private Matrix L;
    private Matrix U;
    private Matrix P;
    private LUPDecomposition lup;

    private boolean isExist(Matrix A) {
        return false;
    }

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

    public Matrix getL() {
        return L;
    }

    public Matrix getU() {
        return U;
    }

    public Matrix getP() {
        return lup.getP();
    }

    public double det() {
        if (lup != null) return lup.det();
        double det = 1;
        for (int i = 0; i < U.getRowDimension(); i++) {
            det *= U.get(i ,i);
        }
        return det;
    }

}
