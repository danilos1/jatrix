import com.jatrix.core.Matrix;
import com.jatrix.decompositions.CholeskyDecomposition;
import com.jatrix.decompositions.LUDecomposition;
import com.jatrix.exceptions.DecompositionNotSupportedException;
import com.jatrix.exceptions.MatrixSizeException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CholeskyDecompositionTest {

    @Test(expected = MatrixSizeException.class)
    public void constructorTest_createNonSquareInstanceOfLUDecompositionObject_assertMustThrownMatrixSizeException() {
        // Arrange
        Matrix matrix = new Matrix(new double[][]{{1.6, 2.7}, {-6.8, 0.9}, {3, 4}});

        // Act
        CholeskyDecomposition lu = new CholeskyDecomposition(matrix);
    }

    @Test(expected = DecompositionNotSupportedException.class)
    public void constructorTest_supplyInappropriateInstanceOfCholeskyDecompositionObject_assertMustThrownMatrixSizeException() {
        // Arrange
        Matrix matrix = new Matrix(new double[][]{{4, 12, -16}, {11, 37, -43}, {-16, -43, 98}});

        // Act
        CholeskyDecomposition cd = new CholeskyDecomposition(matrix);
    }

    @Test(expected = DecompositionNotSupportedException.class)
    public void constructorTest_supplyNonPositiveMatrixOfCholeskyDecompositionObject_assertMustThrownMatrixSizeException() {
        // Arrange
        Matrix matrix = new Matrix(new double[][]{{9, 12, -16}, {12, 37, -43}, {-16, -43, 11}});

        // Act
        CholeskyDecomposition cd = new CholeskyDecomposition(matrix);
    }

    @Test
    public void detTest_calculateDeterminantOf3x3Matrix_assertEquals() {
        // Arrange
        Matrix matrix = new Matrix(new double[][]{{4, 12, -16}, {12, 37, -43}, {-16, -43, 98}});
        double expectedDet = new LUDecomposition(matrix).det();

        // Act
        CholeskyDecomposition cd = new CholeskyDecomposition(matrix);
        double actualDet = cd.det();

        // Assert
        assertEquals(expectedDet, actualDet, 1E-8);
    }

}

