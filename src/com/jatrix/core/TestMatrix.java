package com.jatrix.core;

import com.jatrix.decompositions.CholeskyDecomposition;
import com.jatrix.decompositions.LUDecomposition;
import com.jatrix.decompositions.LUPDecomposition;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(new double[][]{{5, 12, 13}, {3, 5, -6}, {2, 0, -8},{-0.5, 2, 1}});
        double[] expectedColumn = {12,5,0,2};

        // Act
        double[] actualColumn = matrix.getColumn(1);
    }
}
