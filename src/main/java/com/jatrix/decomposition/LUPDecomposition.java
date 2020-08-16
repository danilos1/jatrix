package main.java.com.jatrix.decomposition;

import main.java.com.jatrix.Matrix;
import main.java.com.jatrix.MatrixSizeException;

public class LUPDecomposition {
    private Matrix L;
    private Matrix U;
    private Matrix P;
    private int exchanges;
    private StringBuilder sb;


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
        sb = new StringBuilder("The current matrix: \n"+A.toString());
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

            for (int j = i + 1; j < size; j++) {
                double cur = U.get(j, i);
                if (Math.abs(cur) > Math.abs(max)) {
                    max = cur;
                    idx = j;
                }
            }

            if (max == 0) continue;

            if (idx != i) {
                swap(U, i, idx);
                swap(P, i, idx);
                exchanges++;
            }

            for (int k = i + 1; k < size; k++) {
                double div = U.get(k, i) / U.get(i, i);
                L.set(k, i, div);
                for (int j = i; j < size; j++) {
                    U.set(k, j, U.get(k, j) - U.get(i, j) * div);
                }
            }
        }
    }


    public double[] getPArray() {
        double[] pA = new double[P.getRows()];
        for (int i = 0; i < pA.length; i++) {
            for (int j = 0; j < P.getColumns(); j++) {
                if (P.get(i, j) == 1) {
                    pA[i] = j+1;
                }
            }
        }
        return pA;
    }

    public double det() {
        double det = 1;
        for (int i = 0; i < U.getRows(); i++) {
            det *= U.get(i,i);
        }
        return (exchanges & 0b1) == 0 ? det : -det;
    }

    @Override
    public String toString() {
        sb.append("\nPermutation matrix: \n")
                .append(P.toString())
                .append("\nLower triangular matrix: \n")
                .append(L.toString())
                .append("\nUpper triangular matrix: \n")
                .append(U.toString());
        return sb.toString();
    }
}
