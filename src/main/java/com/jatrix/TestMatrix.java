package main.java.com.jatrix;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(new double[][]{{1, 2, 3}, {3, 2, 1}});
        Matrix m2 = new Matrix(new double[][]{{1, 2}, {3, 2}, {3, 2}});
        Matrix m3 = Matrices.mul(m2, m1);
        System.out.println(m3);


    }
}
