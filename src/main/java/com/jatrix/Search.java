package main.java.com.jatrix;

public class Search {
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
