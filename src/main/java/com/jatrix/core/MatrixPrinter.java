package com.jatrix.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Convenient class for representation some matrix into recording its to a file such as markdown or txt. formats
 */
public class MatrixPrinter {
    private Matrix matrix;

    /**
     * Constructs a MatrixPrinter object, received a matrix
     *
     * @param matrix basic matrix, which can be printed into a file
     */
    public MatrixPrinter(Matrix matrix) {
        this.matrix = matrix;
    }


    /**
     * Saves a matrix in a pretty form as a .md (Markdown) file
     *
     * @param file File object, where a matrix will be stored
     * @return boolean result of the saving a file, true if file was successfully written and false elsewhere
     */
    public boolean saveAsMarkdown(File file) {
        return this.saveAsMarkdown(file, false);
    }


    /**
     * A method for saving matrix in a pretty form to a .txt file
     *
     * @param file   File object, where a matrix will be stored
     * @param append boolean if true, then data will be written to the end of the file rather than the beginning
     * @return boolean result of the saving a file, true if file was successfully written and false elsewhere
     */
    public boolean saveAsMarkdown(File file, boolean append) {
        try (FileWriter fileWriter = new FileWriter(file, append)) {
            StringBuilder sb = new StringBuilder();

            int row = matrix.getRowDimension();
            int col = matrix.getColumnDimension();
            sb.append(String.format("**The size of the matrix: %d x %d**<br>", row, col));
            sb.append("**An accuracy: 3**\n\n");


            for (int i = 0; i < col; i++) {
                sb.append(String.format("| %d        ", i + 1));
            }
            sb.append("\n");
            for (int i = 0; i < col; i++) {
                sb.append("|:-----");
            }
            sb.append("\n");
            sb.append(matrix.prettyOut());
            sb.append("\n**The file was saved to: ").append(file.getAbsolutePath()).append("**");
            fileWriter.write(sb.toString() + "\n\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Saves a matrix in a pretty form to the .txt <code>file</code>.
     * @param file a {@link File} object, where a matrix will be stored.
     * @return boolean result of the saving a file, true if file was successfully written and false elsewhere
     */
    public boolean saveAsText(File file) {
        return this.saveAsText(file, false);
    }


    /**
     * Saves a matrix in a pretty form to the .txt <code>file</code>.
     * @param file   File object, where a matrix will be stored
     * @param append boolean if true, then data will be written to the end of the file rather than the beginning
     * @return boolean result of the saving a file, true if file was successfully written and false elsewhere
     */
    public boolean saveAsText(File file, boolean append) {
        try (FileWriter fileWriter = new FileWriter(file, append)) {
            fileWriter.write(String.format("The size of the matrix: %d x %d**\n\n**An accuracy: 3**\n\n",
                    matrix.getRowDimension(), matrix.getColumnDimension()));
            fileWriter.write(matrix.prettyOut());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
