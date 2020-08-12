package main.java.com.jatrix;

import java.util.Arrays;



public class TestMatrix {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(1000, 1000);

        m1.set(999, 999, 9);

        System.out.println(m1.contains(9));
    }
}
