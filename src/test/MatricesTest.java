import com.jatrix.core.Matrices;
import com.jatrix.core.Matrix;
import com.jatrix.exceptions.MatrixSizeException;
import org.junit.Assert;
import org.junit.Test;

public class MatricesTest {
    @Test
    public void addTest_addTwoMatrixSize3x3_assertMustBeEqual() {
        // Arrange
        double[][] n = {
                {1, 2, 3},
                {3, 4, 5},
                {6, 7, 8}
        };

        Matrix m1 = new Matrix(n);
        Matrix m2 = new Matrix(n);
        Matrix expected = new Matrix(new double[][]{{2, 4, 6}, {6, 8, 10}, {12, 14, 16}});

        // Act
        Matrix actual = Matrices.add(m1, m2);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = MatrixSizeException.class)
    public void addTest_addTwoMatrixSize3x3_assertMustBeThrownMatrixSizeException() {
        Matrix m1 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {4, 9, 3}});
        Matrix m2 = new Matrix(new double[][]{{8, 0, -5}, {3, 2, 9}});

        Matrix m3 = Matrices.add(m1, m2);
    }


    @Test
    public void subTest_subTwoMatrixSize3x3_assertMustBeEqual() {
        // Arrange
        double[][] n = {
                {8, 2, 3},
                {3, 3, 5},
                {-6, 7, 8}
        };

        Matrix m1 = new Matrix(n);
        Matrix m2 = new Matrix(n);

        Matrix expected = new Matrix(new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});

        // Act
        Matrix actual = Matrices.sub(m1, m2);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = MatrixSizeException.class)
    public void subTest_subTwoMatrixSize3x3_assertMustBeThrownMatrixSizeException() {
        Matrix m1 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {4, 9, 3}});
        Matrix m2 = new Matrix(new double[][]{{8, 0, -5}, {3, 2, 9}});

        Matrix m3 = Matrices.add(m1, m2);
    }

    @Test
    public void mulTest_mulTwoMatrixSize2x3__3x2_assertMustBeEqual() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});
        Matrix m2 = new Matrix(new double[][]{{1, 2}, {3, 4}, {5, 6}});

        Matrix expected = new Matrix(new double[][]{{22, 28}, {49, 64}});

        // Act
        Matrix actual = Matrices.mul(m1, m2);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = MatrixSizeException.class)
    public void mulTest_mulTwoMatrixSize2x3__3x2_assertMustBeThrownMatrixSizeException() {
        Matrix m1 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Matrix m2 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});

        Matrix m3 = Matrices.mul(m1, m2);
    }

    @Test
    public void mulTest_mulConstantByMatrix_assertMustBeEqual() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        double constant = 10;

        Matrix expected = new Matrix(new double[][]{{10, 20, 30}, {40, 50, 60}, {70, 80, 90}});

        // Act
        Matrix actual = Matrices.mul(constant, m1);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void transposeTest_transposeMatrix_assertMustBeEqual() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});

        Matrix expected = new Matrix(new double[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}});

        // Act
        Matrix actual = Matrices.transpose(m1);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void inverseTest_inverseMatrix_assertMustBeEqual() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{1, 0, 1}, {0, 5, 0}, {5, 0, 1}});

        Matrix expected = new Matrix(new double[][]{{-0.25, 0, 0.25}, {0, 0.2, 0}, {1.25, 0, -0.25}});

        // Act
        Matrix actual = Matrices.inverse(m1);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = MatrixSizeException.class)
    public void inverseTest_inverseMatrix_assertMustBeThrownMatrixSizeException() {
        Matrix m1 = new Matrix(new double[][]{{1}, {4, 5}, {7, 8, 9}});

        Matrix m3 = Matrices.inverse(m1);
    }


}
