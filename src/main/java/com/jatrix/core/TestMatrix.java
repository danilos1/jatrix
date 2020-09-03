package com.jatrix.core;


import com.jatrix.statistics.MatrixStats;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix xCoefficients = new Matrix(new double[][]{{1, 2, 3, 4}, {4, 5, 6, 3}, {7, 8, 9, 10}});
        System.out.println(MatrixStats.colAvg(xCoefficients, 2));

    }
}
