package com.jatrix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(new double[][]{{1,2},{4,5},{7,8}});

        MatrixIterator m = m1.iterator();

        /*int i = 1;
        while (m.hasNext()) {
            System.out.printf("%d element: %.1f%n", i++, m.next());
        }*/

        System.out.println(m1.stream().sum());

    }
}
