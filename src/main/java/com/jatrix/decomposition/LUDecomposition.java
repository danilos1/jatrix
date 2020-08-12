package main.java.com.jatrix.decomposition;

import main.java.com.jatrix.Matrix;
import main.java.com.jatrix.MatrixSizeException;

public class LUDecomposition {
    private Matrix A;
    private Matrix L;
    private Matrix U;

    public LUDecomposition(Matrix A) {
        if (!A.isSquare())
            throw new MatrixSizeException("Invalid matrix to LU decomposition: matrix must be square.\nFounded: " +
                    A.getRows() + " x " + A.getColumns());

        decompose(A);
    }

    private void decompose(Matrix A) {
        U = new Matrix(A.getRows());
        L = new Matrix(A.getRows());


    }

    public Matrix getL() {
        return L;
    }

    public Matrix getU() {
        return U;
    }

    public double det() {
        double det = 0;
        for (int i = 0; i < U.getRows(); i++) {
            det *= U.get(i, i);
        }
        return det;
    }
}
