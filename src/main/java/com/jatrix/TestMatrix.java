package com.jatrix;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(new double[][]{{1,2},{3,4}});
        Matrix m2 = new Matrix(new double[][]{{5,8},{3,2}});

        Matrix m3 = Matrices.sub(m1, m2);
        System.out.println(m3);
    }
}
