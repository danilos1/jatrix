package com.jatrix;

import java.util.Iterator;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(new double[][]{{1,2},{4,5},{7,8}});
        Iterator<Double> m = m1.iterator();

        while (m.hasNext()) {
            double d = m.next();
            System.out.print(d+" ");
        }
    }
}
