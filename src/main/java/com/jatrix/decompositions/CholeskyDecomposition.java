package main.java.com.jatrix.decompositions;

import main.java.com.jatrix.Matrix;
import main.java.com.jatrix.exceptions.DecompositionNotSupportedException;
import main.java.com.jatrix.exceptions.MatrixSizeException;

public class CholeskyDecomposition {
    private Matrix L;
    private Matrix Lt;
    private int sign;

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

    public Matrix getL() {
        return L;
    }

    public Matrix getLt() {
        return Lt;
    }

    public double det() {
        double det = 1;
        for (int i = 0; i < L.getRowDimension(); i++) {
            double d = L.get(i, i);
            det *= d*d;
        }
        return (sign & 0b1) == 0 ? det : -det;
    }
}
