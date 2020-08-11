package main.java.com.jatrix;

import java.util.Arrays;



public class TestMatrix {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(4096,4096, 5);

        System.out.println(m1.stream().sum());
    }
}
