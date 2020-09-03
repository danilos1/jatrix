import com.jatrix.core.Matrix;
import com.jatrix.core.StrassenProduct;
import org.junit.Assert;
import org.junit.Test;

public class StrassenProductTest {
    @Test
    public void mulTest_mulTwoMatricesByStrassensAlgorithm_assertMustBeEqual() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Matrix expected = new Matrix(new double[][]{{30, 36, 42}, {66, 81, 96}, {102, 126, 150}});

        // Act
        Matrix actual = StrassenProduct.mul(m1, m1);

        // Assert
        Assert.assertEquals(expected, actual);
    }
}
