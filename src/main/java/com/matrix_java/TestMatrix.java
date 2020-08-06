package com.matrix_java;

import java.util.*;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix<Integer> matrix = new Matrix<>(new Integer[][]{{1, 2, 3}, {4, 5, 6}});
        Matrix<Integer> matrix1 = matrix.clone();

        System.out.println(matrix);
        System.out.println(matrix1);

        Matrices.transpose(matrix);

        System.out.println(matrix);
        System.out.println(matrix1);
    }
}
