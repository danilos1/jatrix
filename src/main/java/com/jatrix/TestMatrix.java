package main.java.com.jatrix;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(new double[][]{{1, 0.005, 4.3}, {4, 5.6, 3.3}, {1.9, 4.78, 6.12}});

        int a = 4;
        m1 = Matrices.mul(m1, new Matrix(new double[][]{{1,2},{3,4},{4,5}}));

        System.out.println(m1);
    }
}
