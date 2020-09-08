package com.jatrix.core;

import com.jatrix.conversion.MatrixConversion;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(new double[][]{
                {1, 2, 3, 4},
                {4, 5, 6, 7},
                {7, 8, 9, 10},
                {1, 2, 3, 4},
                {4, 5, 6, 7},});
        Matrix m2 = MatrixConversion.addRow(matrix, 1, new double[]{1, 1, 1, 1});
        System.out.println(m2.prettyOut());
    }
}
