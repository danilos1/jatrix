import com.jatrix.core.Matrix;
import com.jatrix.statistics.MatrixStats;
import org.junit.Assert;
import org.junit.Test;

public class MatrixStatsTest {
    @Test
    public void minColumnsTest_minColumnsOfMatrix_assertEquals() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {4, 9, 3}});
        double[] expected = new double[]{1.0, 2.0, 3.0};


        // Act
        double[] actual = MatrixStats.minColumns(m1);


        // Assert
        Assert.assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void maxColumnsTest_maxColumnsOfMatrix_assertEquals() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {4, 9, 3}});
        double[] expected = new double[]{4.0, 9.0, 6.0};


        // Act
        double[] actual = MatrixStats.maxColumns(m1);


        // Assert
        Assert.assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void maxAbsColumnsTest_maxAbsoluteValueOfColumnsOfMatrix_assertEquals() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{-1, 2, -3}, {-114, 5, 6}, {4, 129, 3}});
        double[] expected = new double[]{-114.0, 129.0, 6.0};


        // Act
        double[] actual = MatrixStats.maxAbsColumns(m1);


        // Assert
        Assert.assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void minRowsTest_minRowsOfMatrix_assertEquals() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{1, 12, -33}, {-34, 52, 36}, {41, 129, 39}});
        double[] expected = new double[]{-33.0, -34.0, 39.0};


        // Act
        double[] actual = MatrixStats.minRows(m1);


        // Assert
        Assert.assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void maxRowsTest_maxRowsOfMatrix_assertEquals() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{1, 12, -33}, {-34, 52, 36}, {41, 129, 39}});
        double[] expected = new double[]{12.0, 52.0, 129.0};


        // Act
        double[] actual = MatrixStats.maxRows(m1);


        // Assert
        Assert.assertArrayEquals(expected, actual, 1e-8);
    }


    @Test
    public void maxElementMatrixTest_maxElementOfMatrix_assertEquals() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{7, 12, 3}, {41, 25, 36}, {44, 90, 0}});
        double expected = 90.0;

        // Act
        double actual = MatrixStats.max(m1);

        // Assert
        Assert.assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void minElementMatrixTest_minElementOfMatrix_assertEquals() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{7, 12, 3}, {41, 25, 36}, {44, 90, 0}});
        double expected = 0.0;

        // Act
        double actual = MatrixStats.min(m1);

        // Assert
        Assert.assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void maxDiagonalElementMatrixTest_maxDiagonalElementOfMatrix_assertEquals() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{7, 12, 3}, {41, 25, 36}, {44, 90, 0}});
        double expected = 25.0;

        // Act
        double actual = MatrixStats.maxDiagonal(m1);

        // Assert
        Assert.assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void minDiagonalElementMatrixTest_minDiagonalElementOfMatrix_assertEquals() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{7, 12, 3}, {41, 25, 36}, {44, 90, 0}});
        double expected = 0.0;

        // Act
        double actual = MatrixStats.minDiagonal(m1);

        // Assert
        Assert.assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void maxColumnsMatrixIndexTest_maxColumnsMatrixWithGivenIndex_assertEquals() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{7, 12, 3}, {41, 25, 36}, {44, 90, 0}});
        double expected = 44.0;

        // Act
        double actual = MatrixStats.maxColumns(m1, 0);

        // Assert
        Assert.assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void maxAbsColumnsMatrixIndexTest_maxAbsColumnsMatrixWithGivenIndex_assertEquals() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{-147, 12, 3}, {41, 25, 36}, {44, 90, 0}});
        double expected = -147.0;

        // Act
        double actual = MatrixStats.maxAbsColumns(m1, 0);

        // Assert
        Assert.assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void minColumnsIndexTest_minColumnsOfMatrixWithGivenIndex_assertEquals() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {4, 9, 3}});
        double expected = 2;


        // Act
        double actual = MatrixStats.minColumns(m1, 1);


        // Assert
        Assert.assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void maxRowsIndexTest_maxRowsOfMatrixWithGivenIndex_assertEquals() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{1, 12, -33}, {-34, 52, 36}, {41, 129, 39}});
        double expected = 129;


        // Act
        double actual = MatrixStats.maxRows(m1, 2);


        // Assert
        Assert.assertEquals(expected, actual, 1e-8);
    }


}
