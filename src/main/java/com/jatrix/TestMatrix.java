package main.java.com.jatrix;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix newMatrix = new Matrix(new double[][]{
                {-7.32111111, 5, -0.5555},
                {-1221.555555555, -11111112.51, -1},
                {3, 0.05555, 1}
        });

        System.out.println(newMatrix.prettyOut(3));
    }
}
