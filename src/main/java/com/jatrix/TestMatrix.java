package main.java.com.jatrix;

import java.util.Arrays;



public class TestMatrix {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(128);
        Matrix m2 = new Matrix(128);


<<<<<<< HEAD
        int a = 4;
        m1 = Matrices.mul(m1, new Matrix(new double[][]{{1,2},{3,4},{4,5}}));
=======
        Matrix m3 = Matrices.mul(m1,m2);
>>>>>>> 00915ebd26abd52e10668d47e4c94d5b373f93dc

    }
}
