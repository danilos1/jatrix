import com.jatrix.core.Matrices;
import com.jatrix.core.Matrix;
import org.junit.Assert;
import org.junit.Test;

public class SimpleOpTests {
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
}
