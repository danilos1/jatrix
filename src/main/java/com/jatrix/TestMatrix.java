package main.java.com.jatrix;

import java.util.Arrays;



public class TestMatrix {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(128);
        Matrix m2 = new Matrix(128);


        Matrix m3 = Matrices.mul(m1,m2);

    }
}
