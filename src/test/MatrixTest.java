import com.jatrix.core.Matrix;
import com.jatrix.exceptions.MatrixSizeException;
import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {

    @Test
    public void constructor1Test_createdMatrix4x3_assertEquals() {
        // Arrange
        Matrix expected = new Matrix(new double[][]{
                {0,0,0}, {0,0,0},
                {0,0,0}, {0,0,0}
        });

        // Act
        Matrix actual = new Matrix(4,3);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructor2Test_createdMatrix2x2_assertEquals() {
        // Arrange
        double[][] a = {
                {1, 2},
                {4, 5},
                {-6, 5},
        };
        int expectedRow = a.length;
        int expectedCol = a[0].length;

        // Act
        Matrix actual = new Matrix(a);
        int actualRow = actual.getRowDimension();
        int actualCol = actual.getColumnDimension();

        // Assert
        Assert.assertEquals(expectedRow, actualRow);
        Assert.assertEquals(expectedCol, actualCol);
    }

    @Test(expected = MatrixSizeException.class)
    public void constructor2Test_createdMatrix2x2_assertMustBeThrownMatrixSizeException() {
        // Arrange
        double[][] a = {
                {1, 2},
                {4   }
        };

        // Act
        Matrix matrix = new Matrix(a);
    }


    @Test
    public void constructor3Test_createdMatrix3x3_assertEquals() {
        // Arrange
        double val = 2;
        Matrix expected = new Matrix(new double[][]{
                {val,val,val},
                {val,val,val},
                {val,val,val},
        });

        // Act
        int size = 3;
        Matrix actual = new Matrix(size, val);

        // Assert
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void identityTest_matrixIsChangedToIdentity_assertTrue() {
        Matrix expected = new Matrix(new double[][]{{1,0,0},{0,1,0},{0,0,1}});
        Matrix m = new Matrix(3,3).identity();
        Assert.assertEquals(expected, m);
    }


    @Test(expected = MatrixSizeException.class)
    public void identityTest_matrixIsChangedToIdentity_assertMust() {
        // Arrange
        Matrix matrix = new Matrix(3,4);

        // Act
        matrix.identity();
    }

    @Test
    public void getTransposeTest_getTransposedMatrix2x3_assertEquals() {
        // Arrange
        Matrix m = new Matrix(new double[][]{{-5, 0, 6},{3.4, 5, -8}});
        Matrix expected = new Matrix(new double[][]{
                {-5, 3.4},
                { 0, 5},
                { 6,-8},
        });

        // Act
        Matrix actual = m.getTranspose();

        // Assert
        Assert.assertEquals(expected, actual);
    }
}
