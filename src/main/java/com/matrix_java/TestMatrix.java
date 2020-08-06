package com.matrix_java;

import java.util.*;

public class TestMatrix {
    public static void main(String[] args) {
        Integer[][] arr  = {{1,2, 3}, {4,5,6}};
        Matrix<Integer> matrix = new Matrix<>(arr);

        System.out.println(matrix);
        Matrices.transpose(matrix);
        System.out.println(matrix);
        System.out.println("Hello world");
    }
}
