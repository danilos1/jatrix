package main.java.com.jatrix;

import static main.java.com.jatrix.Matrices.mul;
import static main.java.com.jatrix.Matrices.add;
import static main.java.com.jatrix.Matrices.sub;

/**
 * Class Strassen
 **/
public class Strassen {
    public static Matrix mul_Strassen(Matrix A, Matrix B) {
        if (A.getColumns() != B.getRows())
            throw new MatrixSizeException("Invalid multiplication operation. Number of columns of the first matrix " +
                    "must be equaled to number of rows of the second one. Expected: " + A.getColumns() + ", but founded: "
                    + B.getRows());

        /** Function to multiply matrices **/

        int n = A.getRows();
        Matrix newMatrix = new Matrix(n, n);

        /** base case **/
        if (n == 1) {
            //newMatrix.get(0, 0) = A.get(0, 0) * B.get(0, 0);
        } else {
            Matrix A11 = new Matrix(n / 2, n / 2);
            Matrix A12 = new Matrix(n / 2, n / 2);
            Matrix A21 = new Matrix(n / 2, n / 2);
            Matrix A22 = new Matrix(n / 2, n / 2);

            Matrix B11 = new Matrix(n / 2, n / 2);
            Matrix B12 = new Matrix(n / 2, n / 2);
            Matrix B21 = new Matrix(n / 2, n / 2);
            Matrix B22 = new Matrix(n / 2, n / 2);

            /** Dividing matrix A into 4 halves **/
            split(A, A11, 0, 0);
            split(A, A12, 0, n / 2);
            split(A, A21, n / 2, 0);
            split(A, A22, n / 2, n / 2);
            /** Dividing matrix B into 4 halves **/
            split(B, B11, 0, 0);
            split(B, B12, 0, n / 2);
            split(B, B21, n / 2, 0);
            split(B, B22, n / 2, n / 2);

            /**
             * M1 = (A11 + A22)(B11 + B22)
             * M2 = (A21 + A22) B11
             * M3 = A11 (B12 - B22)
             * M4 = A22 (B21 - B11)
             * M5 = (A11 + A12) B22
             * M6 = (A21 - A11) (B11 + B12)
             * M7 = (A12 - A22) (B21 + B22)
             **/

            //int[][] M1 = mul(add(A11, A22), add(B11, B22));
            //int[][] M2 = mul(add(A21, A22), B11);
            //int[][] M3 = mul(A11, sub(B12, B22));
            //int[][] M4 = mul(A22, sub(B21, B11));
            //int[][] M5 = mul(add(A11, A12), B22);
            //int[][] M6 = mul(sub(A21, A11), add(B11, B12));
            //int[][] M7 = mul(sub(A12, A22), add(B21, B22));

            /**
             C11 = M1 + M4 - M5 + M7
             C12 = M3 + M5
             C21 = M2 + M4
             C22 = M1 - M2 + M3 + M6
             **/

            //int[][] C11 = add(sub(add(M1, M4), M5), M7);
            //int[][] C12 = add(M3, M5);
            //int[][] C21 = add(M2, M4);
            //int[][] C22 = add(sub(add(M1, M3), M2), M6);

            /** join 4 halves into one result matrix **/
            //join(C11, newMatrix, 0, 0);
            //join(C12, newMatrix, 0, n / 2);
            //join(C21, newMatrix, n / 2, 0);
            //join(C22, newMatrix, n / 2, n / 2);
        }
        /** return result **/
        return newMatrix;
    }

    /**
     * Function to split parent matrix into child matrices
     **/
    public static void split(Matrix m3, Matrix m4, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < m4.getRows(); i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < m4.getRows(); j1++, j2++) {
                // m4[i1][j1] = m3[i2],[j2];
            }
        }
    }

    /**
     * Function to join child matrices int parent matrix
     **/
    public static void join(Matrix m3, Matrix m4, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < m3.getRows(); i1++, i2++)
            for (int j1 = 0, j2 = jB; j1 < m3.getRows(); j1++, j2++)
        //m4[i2][j2] = m3[i1][j1];
    }
}
