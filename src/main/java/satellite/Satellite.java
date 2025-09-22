package satellite;

import java.io.*;
import java.util.*;

public class Satellite {

    static int[][] oldImage;
    static int[][] newImage;
    static int noOfRows, noOfCols;

    public static void main(String[] args) {
        try {
           // {read from input.txt}
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            noOfRows = Integer.parseInt(reader.readLine().trim());
            noOfCols = Integer.parseInt(reader.readLine().trim());

            oldImage = new int[noOfRows][noOfCols];
            newImage = new int[noOfRows][noOfCols];

            // {read old image}
            for (int row = 0; row < noOfRows; row++) {
                String[] parts = reader.readLine().trim().split("\\s+");
                for (int col = 0; col < noOfCols; col++) {
                    oldImage[row][col] = Integer.parseInt(parts[col]);
                }
            }

            // {read new image}
            for (int row = 0; row < noOfRows; row++) {
                String[] parts = reader.readLine().trim().split("\\s+");
                for (int col = 0; col < noOfCols; col++) {
                    newImage[row][col] = Integer.parseInt(parts[col]);
                }
            }

            reader.close();

            // {determine upper corner}
            int x1 = 0;
            while (x1 < noOfRows && equalRows(x1)) x1++;

            int y1 = 0;
            while (y1 < noOfCols && equalCols(y1)) y1++;

            // {determine lower corner}
            int x2 = noOfRows - 1;
            while (x2 >= 0 && equalRows(x2)) x2--;

            int y2 = noOfCols - 1;
            while (y2 >= 0 && equalCols(y2)) y2--;

            // {output}
            if (x1 > x2 || y1 > y2) {
                System.out.println("The two images are the same");
            } else {
                System.out.println(x1 + " " + y1 + " " + (x2) + " " + (y2));
            }

        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }
    }

    // {check if a row is equal in both images}
    public static boolean equalRows(int row) {
        for (int col = 0; col < noOfCols; col++) {
            if (oldImage[row][col] != newImage[row][col]) {
                return false;
            }
        }
        return true;
    }

    // {check if a column is equal in both images}
    public static boolean equalCols(int col) {
        for (int row = 0; row < noOfRows; row++) {
            if (oldImage[row][col] != newImage[row][col]) {
                return false;
            }
        }
        return true;
    }
}