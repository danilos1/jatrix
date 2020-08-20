package com.jatrix.core;

import java.io.File;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix newMatrix = new Matrix(5);
        Matrices.fillRandom(newMatrix);

        File file = new File("target/out.md");
        MatrixPrinter printer = new MatrixPrinter(newMatrix);
        printer.saveAsMarkdown(file,true);
    }
}
