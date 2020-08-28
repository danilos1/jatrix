import com.jatrix.core.Matrix;
import com.jatrix.core.StrassenProduct;
import com.jatrix.solvers.CramerSolver;
import org.junit.Assert;
import org.junit.Test;

public class CramerSolverTest {
    @Test
    public void constructor1Test_CramerSolver_assertEquals() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{2, 2, -1}, {-4, 1, 1}, {4, -3, 2}});
        double[] b = {3, 4, 5};
        double[] expected = {1, 2, 3};

        // Act
        CramerSolver actual = new CramerSolver(m1, b);

        // Assert
        //Assert.assertTrue(Math.abs(expected - actual) < 0.0001);

    }

}
