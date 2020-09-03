import com.jatrix.core.Matrix;
import com.jatrix.core.MatrixIterator;
import com.jatrix.exceptions.MatrixSizeException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void constructor1Test_createdMatrix2x2_assertEquals() {
        // Arrange
        double[][] expectedArray = {
                {1, 2},
                {4, 5},
                {-6, 5},
        };
        int expectedRow = expectedArray.length;
        int expectedCol = expectedArray[0].length;

        // Act
        Matrix actual = new Matrix(expectedArray);
        int actualRow = actual.getRowDimension();
        int actualCol = actual.getColumnDimension();

        // Assert
        assertEquals(expectedRow, actualRow);
        assertEquals(expectedCol, actualCol);
    }

    @Test(expected = MatrixSizeException.class)
    public void constructor1Test_createdMatrix2x2_assertMustBeThrownMatrixSizeException() {
        // Arrange
        double[][] a = {
                {1, 2},
                {4}
        };

        // Act
        Matrix matrix = new Matrix(a);
    }

    @Test
    public void constructor2Test_createdMatrix4x3_assertEquals() {
        // Arrange
        Matrix expected = new Matrix(new double[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });
        int expectedRow = 4;
        int expectedCol = 3;

        // Act
        Matrix actual = new Matrix(4, 3);
        int actualRow = actual.getRowDimension();
        int actualCol = actual.getColumnDimension();

        // Assert
        assertEquals(expected, actual);
        assertEquals(expectedRow, actualRow);
        assertEquals(expectedCol, actualCol);
    }

    @Test
    public void constructor2WithValueTest_createdMatrix3x3_assertEquals() {
        // Arrange
        int val = 4;
        Matrix expected = new Matrix(new double[][]{
                {val, val, val},
                {val, val, val},
                {val, val, val},
        });

        // Act
        Matrix actual = new Matrix(3, 3, val);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void constructor3Test_createdMatrix3x3_assertEquals() {
        // Arrange
        Matrix expected = new Matrix(new double[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
        });

        // Act
        int size = 3;
        Matrix actual = new Matrix(size);
        int actualRow = actual.getRowDimension();
        int actualCol = actual.getColumnDimension();


        // Assert
        assertEquals(expected, actual);
        assertEquals(actualRow, actualCol);
    }


    @Test
    public void constructor3WithValueTest_createdMatrix3x3_assertEquals() {
        // Arrange
        double val = 2;
        Matrix expected = new Matrix(new double[][]{
                {val, val, val},
                {val, val, val},
                {val, val, val},
        });

        // Act
        int size = 3;
        Matrix actual = new Matrix(size, val);

        // Assert
        assertEquals(expected, actual);
    }


    @Test
    public void identityTest_matrixIsChangedToIdentity_assertTrue() {
        // Arrange
        Matrix expected = new Matrix(new double[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});

        // Act
        Matrix m = new Matrix(3, 3).identity();

        // Assert
        assertEquals(expected, m);
    }


    @Test(expected = MatrixSizeException.class)
    public void identityTest_matrixIsChangedToIdentity_assertMust() {
        // Arrange
        Matrix matrix = new Matrix(3, 4);

        // Act
        matrix.identity();
    }

    @Test
    public void getTransposeTest_getTransposedMatrix2x3_assertEquals() {
        // Arrange
        Matrix m = new Matrix(new double[][]{{-5, 0, 6}, {3.4, 5, -8}});
        Matrix expected = new Matrix(new double[][]{
                {-5, 3.4},
                {0, 5},
                {6, -8},
        });

        // Act
        Matrix actual = m.getTranspose();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void isSquareTest_checkIfMatrixIsSquare_assertTrueFalse() {
        // Arrange
        Matrix matrix1 = new Matrix(3, 4);
        Matrix matrix2 = new Matrix(2, 2);

        // Act
        boolean actual1 = matrix1.isSquare();
        boolean actual2 = matrix2.isSquare();

        // Assert
        assertTrue(actual2);
        assertFalse(actual1);
    }

    @Test
    public void equalsTest_checkIfMatricesAreEqualedToEachOther_assertEquals() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{
                {1.5, 6.4, 3},
                {1, 2.9, 1.89},
        });
        Matrix m2 = new Matrix(new double[][]{
                {1.5, 6.4, 3},
                {1.0, 2.9, 1.89},
        });
        Matrix m3 = new Matrix(new double[][]{
                {1.5, 6.4, 3},
                {1, 2.9, 1.89},
                {1, 2.9, 1.89},
        });

        // Act
        boolean actual1 = m1.equals(m2);
        boolean actual2 = m2.equals(m3);

        // Assert
        assertTrue(actual1);
        assertFalse(actual2);
    }

    @Test
    public void streamTest_checkMatrixStream_assertEquals() {
        // Arrange
        Matrix matrix = new Matrix(new double[][]{
                {1, -9.6, 3, 5.7},
                {-1, 4, 4, 9},
        });
        double[] expectedArr = {1, -9.6, 3, 5.7, -1, 4, 4, 9};

        // Act
        double[] actualArr = matrix.stream().toArray();

        // Assert
        Assert.assertArrayEquals(expectedArr, actualArr, 1E-8);
    }

    @Test
    public void isPairTest_checkIfMatrixIsPair_assertTrueFalse() {
        // Arrange
        Matrix m1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix m2 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});

        // Act
        boolean actual1 = m1.isPair();
        boolean actual2 = m2.isPair();

        // Assert
        Assert.assertTrue(actual1);
        Assert.assertFalse(actual2);
    }

    @Test
    public void clearTest_clearWholeMatrix3x2_assertEquals() {
        // Arrange
        Matrix matrix = new Matrix(new double[][]{
                {-3, 5},
                {0, 12},
                {5.6, -4.3},
        });
        Matrix expectedMatrix = new Matrix(new double[][]{{0, 0}, {0, 0}, {0, 0}});


        // Act
        matrix.clear();

        // Assert
        Assert.assertEquals(expectedMatrix, matrix);
    }


    @Test
    public void containsTest_checkIfSomeItemIsContainedInMatrix_assertTrueFalseTrue() {
        // Arrange
        int item1 = -3;
        double item2 = -5;
        double item3 = 5.6;
        Matrix matrix = new Matrix(new double[][]{
                {-3, 5},
                {0, 12},
                {5.6, -4.3},
        });

        // Act
        boolean actual1 = matrix.contains(item1);
        boolean actual2 = matrix.contains(item2);
        boolean actual3 = matrix.contains(item3);

        // Assert
        Assert.assertTrue(actual1);
        Assert.assertFalse(actual2);
        Assert.assertTrue(actual3);
    }

    @Test
    public void setMatrixTest_setNewMatrixToMatrix_assertEquals() {
        // Arrange
        Matrix matrix = new Matrix(new double[][]{
                {2, 5, -15},
                {0, 0, 7},
                {9, 4.5, 3},
        });
        Matrix matrix2 = new Matrix(new double[][]{
                {11, 5, 13},
                {12, 14, 8},
                {9, -6.7, 0},
        });


        // Act
        double[][] m = {
                {2, 5, -15},
                {0, 0, 7},
                {9, 4.5, 3}
        };
        matrix2.setMatrix(m);

        // Assert
        Assert.assertEquals(matrix, matrix2);
    }


    @Test
    public void hasCodeTest_setNewMatrixToMatrix_assertEquals() {
        // Arrange
        Matrix matrix1 = new Matrix(new double[][]{
                {2, 5, -15},
                {0, 0, 7},
                {9, 4.5, 3},
        });
        Matrix matrix2 = new Matrix(new double[][]{
                {2, 5, -15},
                {0, 0, 7},
                {9, 4.5, 3},
        });


        // Act
        int actual1 = matrix1.hashCode();
        int actual2 = matrix2.hashCode();

        // Assert
        assertNotEquals(actual1, actual2);
    }

    @Test
    public void cloneTest_createCloneOfMatrix3x3_assertNotEquals() {
        // Arrange
        Matrix matrix = new Matrix(new double[][]{{2.9, -9, 12}, {3.5, 5.5, 6}, {-4, 2, -2}});
        int expectedHashCode = matrix.hashCode();

        // Act
        Matrix clonedMatrix = matrix.clone();
        int actualHashCode = clonedMatrix.hashCode();

        // Assert
        assertNotEquals(expectedHashCode, actualHashCode);
    }

    @Test
    public void getRowTest_getRowOfMatrix4x3_assertEquals() {
        // Arrange
        Matrix matrix = new Matrix(new double[][]{{5, 12, 13}, {3, 5, -6}, {2, 0, -8}, {-0.5, 2, 1}});
        double[] expectedRow = {2, 0, -8};

        // Act
        double[] actualRow = matrix.getRow(2);

        // Assert
        assertArrayEquals(expectedRow, actualRow, 1E-8);
    }

    @Test
    public void getColumnTest_getRowOfMatrix4x3_assertEquals() {
        // Arrange
        Matrix matrix = new Matrix(new double[][]{{5, 12, 13}, {3, 5, -6}, {2, 0, -8}, {-0.5, 2, 1}});
        double[] expectedColumn = {12, 5, 0, 2};

        // Act
        double[] actualColumn = matrix.getColumn(1);

        // Assert
        assertArrayEquals(expectedColumn, actualColumn, 1E-8);
    }

    @Test
    public void setRowTest_setRowOfMatrix4x3_assertEquals() {
        // Arrange
        Matrix matrix = new Matrix(new double[][]{{0, 1, 13}, {5, -7, 7}, {8, 0, -8}, {9, 3, 1}});
        Matrix newMatrix = matrix.clone();

        // Act
        double[] newRow = {9, 9, 5};
        matrix.setRow(1, newRow);

        // Assert
        assertNotEquals(matrix, newMatrix);
    }

    @Test
    public void setColumnTest_setColumnOfMatrix4x3_assertEquals() {
        // Arrange
        Matrix matrix = new Matrix(new double[][]{{0, 1, 13}, {5, -7, 7}, {8, 0, -8}, {9, 3, 1}});
        Matrix newMatrix = matrix.clone();

        // Act
        double[] newColumn = {8, 3, 0, -6};
        matrix.setColumn(0, newColumn);

        // Assert
        assertNotEquals(matrix, newMatrix);
    }

    @Test
    public void iteratorTest_getAnIteratorOfMatrix2x2_assertEquals() {
        // Arrange
        Matrix matrix = new Matrix(new double[][]{{9, 0.5}, {6, -5.4}});
        double expectedNext = 9;

        // Act
        MatrixIterator matrixIterator = matrix.iterator();
        boolean actualHasNext = matrixIterator.hasNext();
        double actualNext = matrixIterator.next();

        // Assert
        assertTrue(actualHasNext);
        assertEquals(expectedNext, actualNext, 1E-8);
    }
}
