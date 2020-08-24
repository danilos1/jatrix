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
        Matrix m1 = new Matrix(new double[][]{{1,2,3},{4,5,6},{4,9,3}});
        Matrix m2 = new Matrix(new double[][]{{8,0,-5},{3,2,9}});

        Matrix m3 = Matrices.add(m1,m2);
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

        Matrix expected = new Matrix(new double[][]{{7, 3, 1}, {6, 8, 10}, {12, 14, 16}});

        // Act
        Matrix actual = Matrices.add(m1, m2);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = MatrixSizeException.class)
    public void subTest_subTwoMatrixSize3x3_assertMustBeThrownMatrixSizeException() {
        Matrix m1 = new Matrix(new double[][]{{1,2,3},{4,5,6},{4,9,3}});
        Matrix m2 = new Matrix(new double[][]{{8,0,-5},{3,2,9}});

        Matrix m3 = Matrices.add(m1,m2);
    }
}
