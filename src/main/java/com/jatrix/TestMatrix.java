package main.java.com.jatrix;

import java.util.Arrays;


public class TestMatrix {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(5, 5, 10);
        double[][] n =
                {{-1, 0.02, 4, 5, 9},
                {40, 58, 6190, 6, 69},
                {71, 8, 9, 9, 5},
                {0, 5, 9, 0, 1}};
        Matrix m2 = new Matrix(n);

        double array = Search.minDiagonal(m2);
        System.out.println(array);


    }
}
