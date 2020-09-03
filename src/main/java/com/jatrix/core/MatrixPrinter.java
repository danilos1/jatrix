package com.jatrix.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Convenience class for representation some matrix into recording its to a file such as markdown or txt.
 */

public class MatrixPrinter {
    private Matrix matrix;

    /**
     * Constructs a MatrixPrinter object, received a matrix.
     * @param matrix basic matrix, which can be printed into a file.
     */

    public MatrixPrinter(Matrix matrix) {
        this.matrix = matrix;
    }

    /**
     * Saves a matrix in a pretty form as a .md (Markdown) file.
     * @param file File object, where a matrix will be stored.
     */

    public void saveAsMarkdown(File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            StringBuilder sb = new StringBuilder();

            int row = matrix.getRowDimension();
            int col = matrix.getColumnDimension();
            sb.append(String.format("**The size of the matrix: %d x %d**<br>",row, col));
            sb.append("**An accuracy: 3**\n\n");

            for (int i = 0; i < col; i++) {
                sb.append(String.format("| %d        ", i+1));
            }
            sb.append("\n");
            for (int i = 0; i < col; i++) {
                sb.append("|:-----");
            }
            sb.append("\n");
            sb.append(matrix.prettyOut());
            sb.append("\n**The file was saved to: ").append(file.getAbsolutePath()).append("**");
            fileWriter.write(sb.toString()+"\n\n");
            System.out.println("The file "+file.getName()+" was successfully written!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * A method for saving matrix in a pretty form to a .txt file
     * @param file File object, where a matrix will be stored.
     * @param append boolean if true, then data will be written to the end of the file rather than the beginning.
     */

    public void saveAsMarkdown(File file, boolean append) {
        try (FileWriter fileWriter = new FileWriter(file, append)) {
            StringBuilder sb = new StringBuilder();

            int row = matrix.getRowDimension();
            int col = matrix.getColumnDimension();
            sb.append(String.format("**The size of the matrix: %d x %d**<br>",row, col));
            sb.append("**An accuracy: 3**\n\n");


            for (int i = 0; i < col; i++) {
                sb.append(String.format("| %d        ", i+1));
            }
            sb.append("\n");
            for (int i = 0; i < col; i++) {
                sb.append("|:-----");
            }
            sb.append("\n");
            sb.append(matrix.prettyOut());
            sb.append("\n**The file was saved to: ").append(file.getAbsolutePath()).append("**");
            fileWriter.write(sb.toString()+"\n\n");
            System.out.println("The file " + file.getName() + " was successfully written!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves a matrix as a .txt file
     * @param file a File object, where a matrix will be stored.
     */

    public void saveAsText(File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(String.format("The size of the matrix: %d x %d**\n\n**An accuracy: 3**\n\n",
                    matrix.getRowDimension(), matrix.getColumnDimension()));
            fileWriter.write(matrix.prettyOut());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints out a matrix in a pretty form to the .txt file.
     * @param file File object, where a matrix will be stored.
     * @param append boolean if true, then data will be written to the end of the file rather than the beginning.
     */

    public void saveAsText(File file, boolean append) {
        try (FileWriter fileWriter = new FileWriter(file, append)) {
            fileWriter.write(String.format("The size of the matrix: %d x %d**\n\n**An accuracy: 3**\n\n",
                    matrix.getRowDimension(), matrix.getColumnDimension()));
            fileWriter.write(matrix.prettyOut());
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
