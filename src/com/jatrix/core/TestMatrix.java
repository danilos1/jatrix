package com.jatrix.core;

import java.util.Arrays;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(new double[][]{
                {1, -9.6, 3, 5.7},
                {-1, 4, 4, 9},
        });
        double[] expected = {1, -9.6, 3, 5.7,-1, 4, 4, 9};

        // Act
        double[] actual = matrix.stream().toArray();


        System.out.println(Arrays.toString(actual));
    }
}
