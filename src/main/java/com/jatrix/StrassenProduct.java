package main.java.com.jatrix;

import static main.java.com.jatrix.Matrices.add;
import static main.java.com.jatrix.Matrices.sub;

public final class StrassenProduct {

    private StrassenProduct() {}

    public static Matrix mul(Matrix m1, Matrix m2) {
        if (m1.getRowDimension() <= 32) {
            return Matrices.mul(m1, m2);
        }

        Matrix[] A = split(m1);
        Matrix[] B = split(m2);

        Matrix p1 = mul(add(A[0], A[3]), add(B[0], B[3]));
        Matrix p2 = mul(add(A[2], A[3]), B[0]);
        Matrix p3 = mul(A[0], sub(B[1], B[3]));
        Matrix p4 = mul(A[3], sub(B[2], B[0]));
        Matrix p5 = mul(add(A[0], A[1]), B[3]);
        Matrix p6 = mul(sub(A[2], A[0]), add(B[0], B[1]));
        Matrix p7 = mul(sub(A[1], A[3]), add(B[2], B[3]));

        Matrix c11 = add(sub(add(p1,p4), p5), p7);
        Matrix c12 = add(p3, p5);
        Matrix c21 = add(p2, p4);
        Matrix c22 = add(sub(add(p1, p3), p2), p6);

        return join(c11, c12, c21, c22);
    }

    public static Matrix[] split(Matrix A) {
        int size = A.getRowDimension() >> 1;
        Matrix a11 = new Matrix(size);
        Matrix a12 = new Matrix(size);
        Matrix a21 = new Matrix(size);
        Matrix a22 = new Matrix(size);

        for (int i = 0; i < size; i++) {
            System.arraycopy(A.getColumn(i), 0, a11.getColumn(i), 0, size);
            System.arraycopy(A.getColumn(i), size, a12.getColumn(i), 0, size);
            System.arraycopy(A.getColumn(size + i), 0, a21.getColumn(i), 0, size);
            System.arraycopy(A.getColumn(size + i), size, a22.getColumn(i), 0, size);
        }

        return new Matrix[]{a11, a12, a21, a22};
    }

    public static Matrix join(Matrix a11, Matrix a12, Matrix a21, Matrix a22) {
        int size = a11.getRowDimension();
        Matrix joinedMatrix = new Matrix(size << 1);

        for (int i = 0; i < size; i++) {
            System.arraycopy(a11.getColumn(i), 0, joinedMatrix.getColumn(i), 0, size);
            System.arraycopy(a12.getColumn(i), 0, joinedMatrix.getColumn(i), size, size);
            System.arraycopy(a21.getColumn(i), 0, joinedMatrix.getColumn(size+i), 0, size);
            System.arraycopy(a22.getColumn(i), 0, joinedMatrix.getColumn(size+i), size, size);
        }

        return joinedMatrix;
    }
}
