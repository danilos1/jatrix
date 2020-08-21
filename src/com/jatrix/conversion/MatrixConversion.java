package com.jatrix.conversion;

import com.jatrix.core.Matrix;

/**
 * A class for performing conversion operation with a matrix, such as swap rows and columns.
 */
public class MatrixConversion {

    private MatrixConversion() {}

    /**
     * Swaps columns of a given matrix <code>m</code>
     * @param m Matrix object to swap rows.
     * @param colIdx1 the first column index to swap.
     * @param colIdx2 the second column index to swap.
     */
    public static void swapColumns(Matrix m, int colIdx1, int colIdx2) {
        double[] tempRow = m.getColumn(colIdx1);
        m.setColumn(colIdx1, m.getColumn(colIdx2));
        m.setColumn(colIdx2, tempRow);
    }

    /**
     * Swaps rows of a given matrix <code>m</code>
     * @param m Matrix object to swap rows.
     * @param rowIdx1 the first row index to swap.
     * @param rowIdx2 the second row index to swap.
     */
    public static void swapRows(Matrix m, int rowIdx1, int rowIdx2) {
        double[] tempRow = m.getRow(rowIdx1);
        m.setRow(rowIdx1, m.getRow(rowIdx2));
        m.setRow(rowIdx2, tempRow);
    }

}
