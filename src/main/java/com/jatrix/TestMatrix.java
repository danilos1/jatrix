package main.java.com.jatrix;

import java.util.*;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(new double[][]{{1, 0.005, 4.3}, {4, 5.6, 3.3}, {1.9, 4.78, 6.12}});

        m1.stream().max().ifPresent((val) -> System.out.printf("Max value is %.3f%n",val));
        m1.stream().min().ifPresent((val) -> System.out.printf("Min value is %.3f%n",val));
    }
}
