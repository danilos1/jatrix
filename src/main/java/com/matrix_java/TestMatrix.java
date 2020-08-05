package com.matrix_java;


public class TestMatrix {
    public static void main(String[] args) {
        Matrix<Integer> matrix = new Matrix<>(new Integer[][]{{1, 2}, {2, 3}});
        matrix.getTranspose();
        System.out.println(matrix);
    }
}
