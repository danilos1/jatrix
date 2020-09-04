package com.jatrix.core;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(5).random(5.4);
        System.out.println(matrix.prettyOut(4));
    }
}
