package com.jatrix;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix a = new Matrix(new double[][] {{1,2,3}, {4, 5, 6}});
        Matrix b = new Matrix(new double[][] {{6,5,4}, {3, 2, 1}});
        Matrix c = Matrices.add(a, b);

        System.out.println(c);
    }
}
