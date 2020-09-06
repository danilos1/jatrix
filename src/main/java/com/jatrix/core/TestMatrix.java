package com.jatrix.core;

import com.jatrix.printer.MatrixPrinter;

import java.io.File;
import java.io.FileNotFoundException;

public class TestMatrix {
    public static void main(String[] args) throws FileNotFoundException {
        Matrix a = new Matrix(new double[][]{
                { -5, 3, -1 },
                {  0, 8,  2 },
                { 12, 7, -6 },
        });

        MatrixPrinter printer = new MatrixPrinter(a);
        printer.saveAsHtml(new File("C:\\Users\\Admin\\IdeaProjects\\jatrix\\src\\main\\java\\com\\jatrix\\printer\\matrix.html"), 3);
    }
}
