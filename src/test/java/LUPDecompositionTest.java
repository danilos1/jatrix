import com.jatrix.core.Matrix;
import com.jatrix.decompositions.LUDecomposition;
import com.jatrix.decompositions.LUPDecomposition;
import com.jatrix.exceptions.MatrixSizeException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LUPDecompositionTest {

    @Test(expected = MatrixSizeException.class)
    public void constructorTest_createNonSquareInstanceOfLUPDecompositionObject_assertMustThrownMatrixSizeException() {
        // Arrange
        Matrix matrix = new Matrix(new double[][]{{1.6, 2.7}, {-6.8, 0.9}, {3, 4}});

        // Act
        LUPDecomposition lup = new LUPDecomposition(matrix);
    }

    @Test
    public void detTest_calculateDeterminantOf3x3Matrix_assertEquals() {
        // Arrange
        Matrix[] matrix = {new Matrix(new double[][]{{2, 4, -4}, {1, -4, 3}, {-6, -9, 5}}),
                new Matrix(new double[][]{{0, 4, -4}, {0, 0, -1.5}, {3.56, 9, 12}}),
                new Matrix(new double[][]{{0, 4, -4}, {0, 0, -1.5}, {0, 9, 12}})
        };
        LUPDecomposition[] lup = {
                new LUPDecomposition(matrix[0]),
                new LUPDecomposition(matrix[1]),
                new LUPDecomposition(matrix[2])
        };
        double[] expectedDet = {54.0, -21.36, 0};

        // Act
        double[] actualDet = {
                lup[0].det(), lup[1].det(), lup[2].det()
        };

        // Assert
        assertEquals(expectedDet[0], actualDet[0], 1E-8);
        assertEquals(expectedDet[1], actualDet[1], 1E-8);
        assertEquals(expectedDet[2], actualDet[2], 1E-8);
    }
}
