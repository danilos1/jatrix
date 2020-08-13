package main.java.com.jatrix.decomposition;

import main.java.com.jatrix.Matrix;
import main.java.com.jatrix.MatrixSizeException;

public class LUPDecomposition {
    private Matrix L;
    private Matrix U;
    private Matrix P;


    public Matrix getL() {
        return L;
    }


    public Matrix getU() {
        return U;
    }


    public Matrix getP() {
        return P;
    }


    public LUPDecomposition(Matrix A) {
        if (!A.isSquare())
            throw new MatrixSizeException("Invalid matrix to LU decomposition: matrix must be square.\nFounded: " +
                    A.getRows() + " by " + A.getColumns());
        decompose(A);
    }


    private void swap(Matrix m, int row1, int row2) {
        double[] tempRow = m.getRow(row1);
        m.setRow(row1, m.getRow(row2));
        m.setRow(row2, tempRow);
    }


    private void decompose(Matrix A) {
        int size = A.getRows();
        P = new Matrix(size).identity();
        L = P.clone();
        U = A.clone();


        for (int i = 0; i < size - 1; i++) {
            int idx = i;
            double max = U.get(idx, idx);

            for (int j = i+1; j < size; j++) {
                double cur = U.get(j, i);
                if (Math.abs(cur) > Math.abs(max)) {
                    max = cur;
                    idx = j;
                }
            }

            if (idx != i) {
                swap(U, i, idx);
                swap(P, i, idx);
            }

            for (int k = i+1; k < size; k++) {
                double div = U.get(k,i)/U.get(i,i);
                L.set(k, i, div);
                for (int j = i; j < size; j++) {
                    U.set(k, j, U.get(k,j) - U.get(i,j)*div);
                }
            }
        }
    }


    public double det() {
        double det = 1;
        for (int i = 0; i < U.getRows(); i++) {
            det *= U.get(i,i);
        }

        return det;
    }
}
