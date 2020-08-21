package com.jatrix.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Represents record of the matrix in the files markdown or txt
 */

public class MatrixPrinter {
    private Matrix matrix;

    /**
     * Represents constructor, which assign matrix to field of class MatrixPrinter
     * @param matrix - a basic matrix
     */

    public MatrixPrinter(Matrix matrix) {
        this.matrix = matrix;
    }

    /**
     * Saves matrix as markdown file
     * @param file record the final result
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
     * Append items to the markdown file
     * @param file record the final result
     * @param append add specified values
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
     * Saves matrix as text file
     * @param file record the final result
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
     * Append items to the txt file
     * @param file record the final result
     * @param append add specified values
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
