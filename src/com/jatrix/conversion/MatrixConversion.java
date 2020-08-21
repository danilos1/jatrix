package com.jatrix.conversion;

import com.jatrix.core.Matrix;

/**
 * Method for performing swap rows and columns
 */

public class MatrixConversion {

    private MatrixConversion() {}

    /**
     * Swap columns of given matrix
     * @param m - a basic matrix
     * @param row1 - first row
     * @param row2 - second row
     */

    public static void swapColumns(Matrix m, int row1, int row2) {
        double[] tempRow = m.getColumn(row1);
        m.setRow(row1, m.getColumn(row2));
        m.setRow(row2, tempRow);
    }

    /**
     * Swap rows of given matrix
     * @param m - a basic matrix
     * @param row1 - first row
     * @param row2 - second row
     */

    public static void swapRows(Matrix m, int row1, int row2) {
        double[] tempRow = m.getRow(row1);
        m.setRow(row1, m.getRow(row2));
        m.setRow(row2, tempRow);
    }

}
