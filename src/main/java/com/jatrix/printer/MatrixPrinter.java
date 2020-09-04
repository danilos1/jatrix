package com.jatrix.printer;

import com.jatrix.core.Matrix;

import java.io.*;

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
     * Saves a matrix in a pretty form as a .html file
     *
     * @param file File object, where a matrix will be stored
     * @return boolean result of the saving a file, true if file was successfully written and false elsewhere
     * @throws FileNotFoundException if <code>file</code> format does not match to .html format
     */
    public boolean saveAsHtml(File file, int accuracy) throws FileNotFoundException{
        if (!file.getName().matches(".+\\.html"))
            throw new FileNotFoundException("The file "+file.getName()+" does not match to .html format");

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file))){
            /*StringBuilder sb = new StringBuilder("<h1>"+getTableTitle() + " table").append("</h1>\n");
            sb.append("<h3>Description: <span class=\"thin_text\">")*/
            int row = matrix.getRowDimension();
            int col = matrix.getColumnDimension();

            StringBuilder page = new StringBuilder("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "\t<meta charset=\"UTF-8\">\n" +
                    "\t<title>Another web page</title>\n" +
                    "\t<link rel=\"stylesheet\" href=\"table.css\">\n" +
                    "\t<link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap\" rel=\"stylesheet\">" +
                    "</head>\n" +
                    "<body>\n\t<h1>Current matrix</h1>\n"
            );
            page.append(String.format("\t<h3>The size of the matrix: <span class=\"thin_text\">%d x %d</span></h3>" +
                    "\n", row, col))
                    .append("\t<h3>An accuracy: <span class=\"thin_text\">")
                    .append(accuracy)
                    .append("</span></h3>\n\t<table>");

            for (int i = 0; i < row; i++) {
                page.append("\n\t<tr>\n");
                for (int j = 0; j < col; j++) {

                    page.append("\t\t<td>").append(String.format("%."+accuracy+"f",matrix.get(i,j))).append("</td>\n");
                }
                page.append("\t</tr>");
            }
            page.append("\n\t</table>\n</body>\n</html>");
            fileWriter.write(page.toString());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Saves a matrix in a pretty form as a .md (Markdown) file
     *
     * @param file File object, where a matrix will be stored
     * @return boolean result of the saving a file, true if file was successfully written and false elsewhere
     * @throws FileNotFoundException if <code>file</code> format does not match to .md format
     */
    public boolean saveAsMarkdown(File file) throws FileNotFoundException  {
        return this.saveAsMarkdown(file, false);
    }


    /**
     * A method for saving matrix in a pretty form to a .md file
     *
     * @param file   File object, where a matrix will be stored
     * @param append boolean if true, then data will be written to the end of the file rather than the beginning
     * @return boolean result of the saving a file, true if file was successfully written and false elsewhere
     * @throws FileNotFoundException if <code>file</code> format does not match to .md format
     */
    public boolean saveAsMarkdown(File file, boolean append) throws FileNotFoundException {
        if (!file.getName().matches(".+\\.md"))
            throw new FileNotFoundException("The file "+file.getName()+" does not match to .md format");

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
    public boolean saveAsText(File file) throws FileNotFoundException {
        return this.saveAsText(file, false);
    }


    /**
     * Saves a matrix in a pretty form to the .txt <code>file</code>.
     * @param file   File object, where a matrix will be stored
     * @param append boolean if true, then data will be written to the end of the file rather than the beginning
     * @return boolean result of the saving a file, true if file was successfully written and false elsewhere
     */
    public boolean saveAsText(File file, boolean append) throws FileNotFoundException{
        if (!file.getName().matches(".+\\.txt"))
            throw new FileNotFoundException("The file "+file.getName()+" does not match to .txt format");

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
