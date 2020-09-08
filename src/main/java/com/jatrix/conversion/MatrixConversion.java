package com.jatrix.conversion;

import com.jatrix.core.Matrix;

/**
 * A class for performing conversion operation with a matrix, such as swap rows and columns.
 */
public class MatrixConversion {

    private MatrixConversion() {
    }


    /**
     * Swaps columns of a given matrix <code>m</code>
     *
     * @param m       Matrix object to swap rows.
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
     *
     * @param m       Matrix object to swap rows.
     * @param rowIdx1 the first row index to swap.
     * @param rowIdx2 the second row index to swap.
     */
    public static void swapRows(Matrix m, int rowIdx1, int rowIdx2) {
        double[] tempRow = m.getRow(rowIdx1);
        m.setRow(rowIdx1, m.getRow(rowIdx2));
        m.setRow(rowIdx2, tempRow);
    }

    /**
     * Adds row of a given matrix by index <code>m</code>
     *
     * @param m     Matrix object to add rows.
     * @param index given index.
     * @param data  given array for a new row.
     * @return      new matrix with added row.
     */
    public static Matrix addRow(Matrix m, int index, double[] data) {
        Matrix out = new Matrix(m.getRowDimension() + 1, m.getColumnDimension());
        for (int i = 0; i < index; i++) {
            out.setRow(i, m.getRow(i));
        }
        out.setRow(index, data);
        for (int i = index + 1; i < out.getRowDimension(); i++) {
            out.setRow(i, m.getRow(i - 1));
        }
        return out;
    }

    /**
     * Adds column of a given matrix by index <code>m</code>
     * @param m     Matrix object to add columns.
     * @param index given index.
     * @param data  given array for a new column.
     * @return      new matrix with added column.
     */
    public static Matrix addColumn(Matrix m, int index, double[] data) {
        Matrix out = new Matrix(m.getRowDimension(), m.getColumnDimension() + 1);
        for (int i = 0; i < index; i++) {
            out.setColumn(i, m.getColumn(i));
        }
        out.setColumn(index, data);
        for (int i = index + 1; i < out.getColumnDimension(); i++) {
            out.setColumn(i, m.getColumn(i - 1));
        }
        return out;
    }

    /**
     * Removes row of a given matrix by index <code>m</code>
     *
     * @param m      Matrix object to remove rows.
     * @param index  given index.
     * @return       new matrix with deleted row.
     */
    public static Matrix removeRow(Matrix m, int index) {
        Matrix out = new Matrix(m.getRowDimension() - 1, m.getColumnDimension());
        for (int i = 0; i < index; i++) {
            out.setRow(i, m.getRow(i));
        }
        for (int i = index; i < out.getRowDimension(); i++) {
            out.setRow(i, m.getRow(i + 1));
        }
        return out;
    }

    /**
     * Removes column of a given matrix by index <code>m</code>
     * @param m     Matrix object to remove columns.
     * @param index given index.
     * @return      new matrix with deleted column.
     */
    public static Matrix removeColumn(Matrix m, int index) {
        Matrix out = new Matrix(m.getRowDimension(), m.getColumnDimension() - 1);
        for (int i = 0; i < index; i++) {
            out.setColumn(i, m.getColumn(i));
        }
        for (int i = index; i < out.getColumnDimension(); i++) {
            out.setColumn(i, m.getColumn(i + 1));
        }
        return out;
    }
}
