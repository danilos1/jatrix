package com.jatrix.core;

import com.jatrix.decompositions.CholeskyDecomposition;
import com.jatrix.decompositions.LUDecomposition;
import com.jatrix.decompositions.LUPDecomposition;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(new double[][]{{0, 1, 13}, {5, -7, 7}, {8, 0, -8},{9, 3, 1}});
        Matrix newMatrix = matrix.clone();

        // Act
        double[] newColumn = {0,5,8,9};
        matrix.setColumn(0, newColumn);

        System.out.println(matrix.prettyOut());
        System.out.println(newMatrix.prettyOut());
    }
}
