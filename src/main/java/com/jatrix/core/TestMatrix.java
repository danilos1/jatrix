package com.jatrix.core;

import com.jatrix.printer.MatrixPrinter;

import java.io.File;
import java.io.FileNotFoundException;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(5);
        Matrices.fillRandom(matrix);

        MatrixPrinter printer = new MatrixPrinter(matrix);
        try {
            System.out.println(printer.saveAsHtml(
                    new File("C:\\Users\\Admin\\IdeaProjects\\jatrix\\src\\main\\java\\com\\jatrix\\printer\\matrix.html"), 9));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
