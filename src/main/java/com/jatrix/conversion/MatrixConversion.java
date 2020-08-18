package main.java.com.jatrix.conversion;

import main.java.com.jatrix.Matrix;

public class MatrixConversion {

    private MatrixConversion() {}


    public static void swapColumns(Matrix m, int row1, int row2) {
        double[] tempRow = m.getColumn(row1);
        m.setRow(row1, m.getColumn(row2));
        m.setRow(row2, tempRow);
    }


    public static void swapRows(Matrix m, int row1, int row2) {
        double[] tempRow = m.getRow(row1);
        m.setRow(row1, m.getRow(row2));
        m.setRow(row2, tempRow);
    }

}
