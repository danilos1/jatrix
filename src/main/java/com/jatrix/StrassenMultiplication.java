package main.java.com.jatrix;

import java.util.Arrays;

public class StrassenMultiplication {

    public static Matrix mul(Matrix A, Matrix B) {
        return null;
    }

    public static Matrix[] split(Matrix A) {
        int size = A.getRows();
        Matrix[] splitedMatrices = {
            new Matrix(size >> 1),
            new Matrix(size >> 1),
            new Matrix(size >> 1),
            new Matrix(size >> 1),
        };

        for (int i = 0; i < size >> 1; i++) {
            System.arraycopy(A.getRow(i), 0, splitedMatrices[0].getRow(i), 0, size >> 1);
            System.arraycopy(A.getRow(i), size >> 1, splitedMatrices[1].getRow(i), 0, size >> 1);
            System.arraycopy(A.getRow((size >> 1) + i), 0, splitedMatrices[2].getRow(i), 0, size >> 1);
            System.arraycopy(A.getRow((size >> 1) + i), size >> 1, splitedMatrices[3].getRow(i), 0, size >> 1);
        }

        return splitedMatrices;
    }

    public static Matrix join(Matrix ulM, Matrix urM, Matrix dlM, Matrix drM) {
        int size = ulM.getRows();
        int newSize = size << 1;
        Matrix joinedMatrix = new Matrix(newSize);

        for (int i = 0; i < size; i++) {
            System.arraycopy(ulM.getRow(i), 0, joinedMatrix.getRow(i), 0, size);
            System.arraycopy(urM.getRow(i), 0, joinedMatrix.getRow(i), size, size);
            System.arraycopy(dlM.getRow(i), 0, joinedMatrix.getRow(size+i), 0, size);
            System.arraycopy(drM.getRow(i), 0, joinedMatrix.getRow(size+i), size, size);
        }

        return joinedMatrix;
    }

}
