package com.jatrix.statistics;

import com.jatrix.core.Matrix;

/**
 * Class for performing general statistical calculations such as min/max, average value of matrix
 */

public class MatrixStats {

    /**
     * Method for obtaining the minimum value of each column of the matrix
     * @param matrix - a given matrix
     * @return minElements - array of minimum values
     */

    public static double[] minColumns(Matrix matrix) {
        double[] minElements = new double[matrix.getColumnDimension()];
        for (int i = 0; i < matrix.getColumnDimension(); i++) {
            double min = matrix.get(0, i);
            for (int j = 0; j < matrix.getRowDimension(); j++) {
                if (matrix.get(j, i) < min) {
                    min = matrix.get(j, i);
                }
            }
            minElements[i] = min;
        }
        return minElements;
    }

    /**
     * Method for obtaining the maximum value of each column of the matrix
     * @param matrix - a given matrix
     * @return maxElements - array of maximum values
     */

    public static double[] maxColumns(Matrix matrix) {
        double[] maxElements = new double[matrix.getColumnDimension()];
        for (int i = 0; i < matrix.getColumnDimension(); i++) {
            double max = matrix.get(0, i);
            for (int j = 0; j < matrix.getRowDimension(); j++) {
                if (matrix.get(j, i) > max) {
                    max = matrix.get(j, i);
                }
            }
            maxElements[i] = max;
        }
        return maxElements;
    }

    /**
     * Method for finding the maximum absolute value of the matrix in columns
     * @param matrix - a given matrix
     * @return maxElements - array of maximum absolute values
     */

    public static double[] maxAbsColumns(Matrix matrix) {
        double[] maxElements = new double[matrix.getColumnDimension()];
        for (int i = 0; i < matrix.getColumnDimension(); i++) {
            double max = matrix.get(0, i);
            for (int j = 0; j < matrix.getRowDimension(); j++) {
                if (Math.abs(matrix.get(j, i)) > Math.abs(max)) {
                    max = matrix.get(j, i);
                }
            }
            maxElements[i] = max;
        }
        return maxElements;
    }

    /**
     * Finding the minimum values in each rows of the matrix
     * @param matrix - a given matrix
     * @return minElements - array of minimum values
     */

    public static double[] minRows(Matrix matrix) {
        double[] minElements = new double[matrix.getRowDimension()];
        for (int i = 0; i < matrix.getRowDimension(); i++) {
            double min = matrix.get(i, 0);
            for (int j = 0; j < matrix.getColumnDimension(); j++) {
                if (matrix.get(i, j) < min) {
                    min = matrix.get(i, j);
                }
            }
            minElements[i] = min;
        }
        return minElements;
    }

    /**
     * Finding the maximum values in each rows of the matrix
     * @param matrix - a given matrix
     * @return maxElements - array of maximum values
     */

    public static double[] maxRows(Matrix matrix) {
        double[] maxElements = new double[matrix.getRowDimension()];
        for (int i = 0; i < matrix.getRowDimension(); i++) {
            double max = matrix.get(i, 0);
            for (int j = 0; j < matrix.getColumnDimension(); j++) {
                if (matrix.get(i, j) > max) {
                    max = matrix.get(i, j);
                }
            }
            maxElements[i] = max;
        }
        return maxElements;
    }

    /**
     * To find the maximum value of the whole matrix
     * @param matrix - a given matrix
     * @return maxElement - maximum number
     */

    public static double max(Matrix matrix) {
        double maxElement = matrix.get(0, 0);
        for (int i = 0; i < matrix.getRowDimension(); i++) {
            for (int j = 0; j < matrix.getColumnDimension(); j++) {
                if (matrix.get(i, j) > maxElement) {
                    maxElement = matrix.get(i, j);
                }
            }
        }
        return maxElement;
    }

    /**
     * To find the minimum value of the whole matrix
     * @param matrix - a given matrix
     * @return minElement - minimum number
     */

    public static double min(Matrix matrix) {
        double minElement = matrix.get(0, 0);
        for (int i = 0; i < matrix.getRowDimension(); i++) {
            for (int j = 0; j < matrix.getColumnDimension(); j++) {
                if (matrix.get(i, j) < minElement) {
                    minElement = matrix.get(i, j);
                }
            }
        }
        return minElement;
    }

    /**
     * Finding the maximum element on the diagonal of the matrix
     * @param matrix - a given matrix
     * @return maxElement - maximum diagonal number
     */

    public static double maxDiagonal(Matrix matrix) {
        double maxElement = matrix.get(0, 0);
        int minRange;
        if (matrix.getRowDimension() > matrix.getColumnDimension()) {
            minRange = matrix.getColumnDimension();
        } else {
            minRange = matrix.getRowDimension();
        }
        for (int i = 0; i < minRange; i++) {
            if (matrix.get(i, i) > maxElement) {
                maxElement = matrix.get(i, i);
            }
        }
        return maxElement;
    }

    /**
     * Finding the minimum element on the diagonal of the matrix
     * @param matrix - a given matrix
     * @return minElement - minimum diagonal number
     */

    public static double minDiagonal(Matrix matrix) {
        double minElement = matrix.get(0, 0);
        int minRange;
        if (matrix.getRowDimension() > matrix.getColumnDimension()) {
            minRange = matrix.getColumnDimension();
        } else {
            minRange = matrix.getRowDimension();
        }
        for (int i = 0; i < minRange; i++) {
            if (matrix.get(i, i) < minElement) {
                minElement = matrix.get(i, i);
            }
        }
        return minElement;
    }

    /**
     * Finding the maximum value for a given column index
     * @param matrix - a given matrix
     * @param index - a given column index
     * @return maxElements - maximum column number
     * @see #maxColumns
     */

    public static double maxColumns(Matrix matrix, int index) {
        double maxElements = 0;
        for (int i = 0; i < matrix.getColumnDimension(); i++) {
            double max = matrix.get(0, index);
            for (int j = 0; j < matrix.getRowDimension(); j++) {
                if (matrix.get(j, index) > max) {
                    max = matrix.get(j, index);
                }
            }
            maxElements = max;
        }
        return maxElements;
    }

    /**
     * Finding the maximum absolute value for a given column index
     * @param matrix - a given matrix
     * @param index - a given column index
     * @return maxElements - maximum column number
     * @see #maxAbsColumns(Matrix)
     */

    public static double maxAbsColumns(Matrix matrix, int index) {
        double maxElements = 0;
        for (int i = 0; i < matrix.getColumnDimension(); i++) {
            double max = matrix.get(0, index);
            for (int j = 0; j < matrix.getRowDimension(); j++) {
                if (Math.abs(matrix.get(j, index)) > Math.abs(max)) {
                    max = matrix.get(j, index);
                }
            }
            maxElements = max;
        }
        return maxElements;
    }

    /**
     * Finding the minimum value for a given column index
     * @param matrix - a given matrix
     * @param index - a given column index
     * @return minElements - minimum column number
     */

    public static double minColumns(Matrix matrix, int index) {
        double minElements = 0;
        for (int i = 0; i < matrix.getColumnDimension(); i++) {
            double min = matrix.get(0, index);
            for (int j = 0; j < matrix.getRowDimension(); j++) {
                if (matrix.get(j, index) < min) {
                    min = matrix.get(j, index);
                }
            }
            minElements = min;
        }
        return minElements;
    }

    /**
     * Finding the maximum value for a given row index
     * @param matrix - a given matrix
     * @param index - a given column index
     * @return maxElements - maximum row number
     */

    public static double maxRows(Matrix matrix, int index) {
        double maxElements = 0;
        for (int i = 0; i < matrix.getRowDimension(); i++) {
            double max = matrix.get(index, 0);
            for (int j = 0; j < matrix.getColumnDimension(); j++) {
                if (matrix.get(index, j) > max) {
                    max = matrix.get(index, j);
                }
            }
            maxElements = max;
        }
        return maxElements;
    }
}
