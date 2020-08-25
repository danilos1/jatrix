import com.jatrix.core.Matrix;
import com.jatrix.decompositions.LUDecomposition;
import com.jatrix.exceptions.MatrixSizeException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LUDecompositionTest {

    @Test(expected = MatrixSizeException.class)
    public void constructorTest_createNonSquareInstanceOfLUDecompositionObject_assertMustThrownMatrixSizeException() {
        // Arrange
        Matrix matrix = new Matrix(new double[][]{{1.6, 2.7}, {-6.8, 0.9}, {3, 4}});

        // Act
        LUDecomposition lu = new LUDecomposition(matrix);
    }

    @Test
    public void detTest_calculateDeterminantOf3x3Matrix_assertEquals() {
        // Arrange
        Matrix[] matrix = {new Matrix(new double[][]{{2, 4, -4}, {1, -4, 3}, {-6, -9, 5}}),
                new Matrix(new double[][]{{0, 4, -4}, {0, 0, -1.5}, {3.56, 9, 12}}),
                new Matrix(new double[][]{{0, 4, -4}, {0, 0, -1.5}, {0, 9, 12}})
        };
        LUDecomposition[] lu = {
                new LUDecomposition(matrix[0]),
                new LUDecomposition(matrix[1]),
                new LUDecomposition(matrix[2])
        };
        double[] expectedDet = {54.0, -21.36, 0};

        // Act
        double[] actualDet = {
                lu[0].det(), lu[1].det(), lu[2].det()
        };

        // Assert
        assertEquals(expectedDet[0], actualDet[0], 1E-15);
        assertEquals(expectedDet[1], actualDet[1], 1E-15);
        assertEquals(expectedDet[2], actualDet[2], 1E-15);
    }


    @Test
    public void getLUTest_getLowerTriangularMatrixOf3x3Matrix_assertEquals() {
        // Arrange
        Matrix matrix = new Matrix(new double[][]{{2, 4, -4}, {1, -4, 3}, {-6, -9, 5}});
        LUDecomposition lu = new LUDecomposition(matrix);
        Matrix expectedL = new Matrix(new double[][]{{1, 0, 0}, {0.5, 1, 0}, {-3, -0.5, 1}});
        Matrix expectedU = new Matrix(new double[][]{{2, 4, -4}, {0, -6, 5}, {0, 0, -4.5}});

        // Act
        Matrix actualL = lu.getL();
        Matrix actualU = lu.getU();

        // Assert
        assertEquals(expectedL, actualL);
        assertEquals(expectedU, actualU);
    }
}
