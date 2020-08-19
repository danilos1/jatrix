package main.java.com.jatrix;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix newMatrix = new Matrix(32);
        Matrices.fillRandom(newMatrix);

        System.out.println(newMatrix.prettyOut());
    }
}
