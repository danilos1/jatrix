package com.jatrix.core;

import com.jatrix.printer.MatrixPrinter;

import java.io.File;
import java.io.FileNotFoundException;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(5);
        Matrices.fillRandom(matrix);

        System.out.println(matrix.prettyOut(4));
    }
}
