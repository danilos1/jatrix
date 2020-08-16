package main.java.com.jatrix.decomposition;

import main.java.com.jatrix.Matrix;
import main.java.com.jatrix.MatrixSizeException;

public class CholeskyDecomposition {

    public CholeskyDecomposition(Matrix A) {
        if (!A.isSquare())
            throw new MatrixSizeException("Invalid matrix to LU decomposition: matrix must be square.\nFounded: " +
                    A.getRows() + " by " + A.getColumns());
        decompose(A);
    }

    private void decompose(Matrix A) {
        if (!A.equals(A.getTranspose())) {
            System.out.println("Matrix does not support a Cholesky decompostition, since matrix doesn't equal " +
                    "to transposed itself");
            return;
        }

        // code
    }
}
