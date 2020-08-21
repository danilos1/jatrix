package com.jatrix.statistics;

import com.jatrix.core.Matrix;

/**
 * Class for performing general statistical calculations such as min/max, average value etc. of a {@link Matrix} object.
 */
public class MatrixStats {


    /**
     * Finds a minimum value of each column of the specified matrix.
     * @param matrix {@link Matrix} object.
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
     * Finds a maximum value of each column of the specified matrix.
     * @param matrix {@link Matrix} object.
     * @return maxElements array of maximum values.
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
     * Finds maximum absolute value of the specified matrix in columns.
     * @param matrix {@link Matrix} object.
     * @return maxElements array of maximum absolute values
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
     * Finds minimum values in each rows of the specified matrix.
     * @param matrix {@link Matrix} object.
     * @return minElements array of minimum values.
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
     * Finds the maximum values in each rows of the specified matrix.
     * @param matrix {@link Matrix} object.
     * @return maxElements array of maximum values.
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
     * Finds a maximum value of the whole specified matrix.
     * @param matrix {@link Matrix} object.
     * @return maxElement maximum number of a whole matrix.
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
     * Finds a minimum value of the whole specified matrix.
     * @param matrix {@link Matrix} object.
     * @return minElement minimum number of a whole matrix.
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
     * Finds a maximum element on the diagonal of the specified matrix.
     * @param matrix {@link Matrix} object.
     * @return maxElement maximum diagonal number
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
     * Finds a minimum element on the diagonal of the specified matrix.
     * @param matrix {@link Matrix} object.
     * @return minElement minimum diagonal number
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
     * Finds a maximum value of the specified matrix for a given column index.
     * @param matrix {@link Matrix} object.
     * @param index matrix column index
     * @return maxElements maximum by column of <code>index</code> position number.
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
     * Finds an absolute maximum value of the specified matrix for a given column index.
     * @param matrix {@link Matrix} object.
     * @param index matrix column index
     * @return maxElements absolute maximum by column of <code>index</code> position number.
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
     * Finds a minimum value of the specified matrix for a given column index.
     * @param matrix {@link Matrix} object.
     * @param index matrix column index
     * @return minElements minimum by column of <code>index</code> position number.
     * @see #minColumns
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
     * Finds a maximum value of the specified matrix for a given row index.
     * @param matrix {@link Matrix} object.
     * @param index matrix row index
     * @return maxElements maximum by row of <code>index</code> position number.
     * @see #maxRows
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
