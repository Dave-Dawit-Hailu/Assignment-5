/*
 * Class: CMSC203 CRN: 30340
 * Instructor: Professor Khandan 
 * 
 * Description: 
 * 
	TwoDimRaggedArrayUtility:
	This class provides utility methods for working with two-dimensional ragged arrays of doubles.
	It includes methods for reading from and writing to files, calculating totals and averages, and finding highest and lowest values in rows and columns.
	The class aims to facilitate common operations on ragged arrays, such as data manipulation and analysis.
*

 * Due: 4/10/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
*  independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Dave| Dawit Hailu
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {


    public TwoDimRaggedArrayUtility() {
        // Constructor
    }

    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int rows = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            rows++;
        }
        scanner.close();

        double[][] data = new double[rows][];
        scanner = new Scanner(file);
        for (int i = 0; i < rows; i++) {
            String[] values = scanner.nextLine().trim().split(" ");
            data[i] = new double[values.length];
            for (int j = 0; j < values.length; j++) {
                data[i][j] = Double.parseDouble(values[j]);
            }
        }
        scanner.close();
        return data;
    }

    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(outputFile);
        for (double[] row : data) {
            for (double value : row) {
                writer.print(value + " ");
            }
            writer.println();
        }
        writer.close();
    }

    public static double getTotal(double[][] data) {
        double total = 0.0;
        for (double[] row : data) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }

    public static double getAverage(double[][] data) {
        int count = 0;
        double total = 0.0;
        for (double[] row : data) {
            for (double value : row) {
                total += value;
                count++;
            }
        }
        return total / count;
    }

    public static double getRowTotal(double[][] data, int row) {
        double total = 0.0;
        for (double value : data[row]) {
            total += value;
        }
        return total;
    }

    public static double getColumnTotal(double[][] data, int col) {
        double total = 0.0;
        for (double[] row : data) {
            if (col < row.length) {
                total += row[col];
            }
        }
        return total;
    }

    public static double getHighestInRow(double[][] data, int row) {
        double highest = data[row][0];
        for (double value : data[row]) {
            if (value > highest) {
                highest = value;
            }
        }
        return highest;
    }

    public static int getHighestInRowIndex(double[][] data, int row) {
        double highest = data[row][0];
        int index = 0;
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] > highest) {
                highest = data[row][i];
                index = i;
            }
        }
        return index;
    }

    public static double getLowestInRow(double[][] data, int row) {
        double lowest = data[row][0];
        for (double value : data[row]) {
            if (value < lowest) {
                lowest = value;
            }
        }
        return lowest;
    }

    public static int getLowestInRowIndex(double[][] data, int row) {
        double lowest = data[row][0];
        int index = 0;
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] < lowest) {
                lowest = data[row][i];
                index = i;
            }
        }
        return index;
    }

    public static double getHighestInColumn(double[][] data, int col) {
        double highest = Double.MIN_VALUE;
        for (double[] row : data) {
            if (col < row.length && row[col] > highest) {
                highest = row[col];
            }
        }
        return highest;
    }

    public static int getHighestInColumnIndex(double[][] data, int col) {
        double highest = Double.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] > highest) {
                highest = data[i][col];
                index = i;
            }
        }
        return index;
    }

    public static double getLowestInColumn(double[][] data, int col) {
        double lowest = Double.MAX_VALUE;
        for (double[] row : data) {
            if (col < row.length && row[col] < lowest) {
                lowest = row[col];
            }
        }
        return lowest;
    }

    public static int getLowestInColumnIndex(double[][] data, int col) {
        double lowest = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] < lowest) {
                lowest = data[i][col];
                index = i;
            }
        }
        return index;
    }

    public static double getHighestInArray(double[][] data) {
        double highest = data[0][0];
        for (double[] row : data) {
            for (double value : row) {
                if (value > highest) {
                    highest = value;
                }
            }
        }
        return highest;
    }

    public static double getLowestInArray(double[][] data) {
        double lowest = data[0][0];
        for (double[] row : data) {
            for (double value : row) {
                if (value < lowest) {
                    lowest = value;
                }
            }
        }
        return lowest;
    }

    /**
     * Retrieves a column from a two-dimensional ragged array.
     * 
     * @param data The two-dimensional ragged array.
     * @param col  The column index.
     * @return An array representing the column.
     */
    public static double[] getColumn(double[][] data, int col) {
        double[] column = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                column[i] = data[i][col];
            }
        }
        return column;
    }
   

	

}
