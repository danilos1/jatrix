package com.matrix_java;

import java.util.*;

public class TestMatrix {
    public static void main(String[] args) {
        Double[][] arr  = {{1., 2., 3.}, {4., 5., 6.}};
        Matrix matrix = new Matrix(new double[][]{{1,2},{3,4}});

        System.out.println(matrix);


    }
}
