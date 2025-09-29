package satellite;

import java.io.*;

public class Satellite {

    static int[][] oldImage;
    static int[][] newImage;
    static int noOfRows, noOfCols;

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String[] firstLine = reader.readLine().trim().split("\\s+");
            noOfRows = Integer.parseInt(firstLine[0]);
            noOfCols = Integer.parseInt(firstLine[1]);

            oldImage = new int[noOfRows][noOfCols];
            newImage = new int[noOfRows][noOfCols];

            // read old image
            for (int row = 0; row < noOfRows; row++) {
                String[] parts = reader.readLine().trim().split("\\s+");
                for (int col = 0; col < noOfCols; col++) {
                    oldImage[row][col] = Integer.parseInt(parts[col]);
                }
            }

            // read new image
            for (int row = 0; row < noOfRows; row++) {
                String[] parts = reader.readLine().trim().split("\\s+");
                for (int col = 0; col < noOfCols; col++) {
                    newImage[row][col] = Integer.parseInt(parts[col]);
                }
            }

            reader.close();

            // call method
            findRectangle();

        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }
    }

    public static void findRectangle() {
        int minRow = noOfRows, minCol = noOfCols;
        int maxRow = -1, maxCol = -1;

        // single loop for all four boundaries
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfCols; col++) {
                if (oldImage[row][col] != newImage[row][col]) {
                    if (row < minRow) minRow = row;
                    if (row > maxRow) maxRow = row;
                    if (col < minCol) minCol = col;
                    if (col > maxCol) maxCol = col;
                }
            }
        }

        if (maxRow == -1) {
            // images identical
            System.out.println("0 0 0 0");
        } else {
            // convert to 1-based
            System.out.println((minRow + 1) + " " + (minCol + 1) + " " +
                    (maxRow + 1) + " " + (maxCol + 1));
        }
    }
}
