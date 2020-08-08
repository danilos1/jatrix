package main.java.com.jatrix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(new double[][]{{1, 2, 4.3}, {4, 5.6, 3.3}, {1.9, 4.78, 6.12}});

        m1.stream().map((val) -> val * 100).forEach(System.out::println);

    }
}
