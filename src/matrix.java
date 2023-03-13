import java.util.*;
public class matrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome To Simple Matrix Calculator!!!!\n");
        int choice = 1;
        while (choice != 0) {
            System.out.println("""
                    which operation you want to perform:
                     1.ADDITION\s
                     2.MULTIPLICATION\s
                     3.SUBTRACTION\s
                     4.TRANSPOSE\s
                     5.DETERMINANT\s
                     0.END\s
                    \s""");
            System.out.println("Select Options From (1-5): ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1 -> {
//        for matrix 1:
                    System.out.println("(Matrix 1) Enter how many rows and columns you want: (R/C)");
                    int row1 = input.nextInt();
                    int col1 = input.nextInt();
                    int[][] matrix1 = InputMatrix(row1, col1, input);
                    System.out.println("Matrix A is: ");
                    PrintMatrix(matrix1);
//        for matrix 2:
                    System.out.println("(Matrix 2) Enter how many rows and columns you want: (R/C)");
                    int row2 = input.nextInt();
                    int col2 = input.nextInt();
                    int[][] matrix2 = InputMatrix(row2, col2, input);
                    System.out.println("Matrix B is: ");
                    PrintMatrix(matrix2);
//        for add 2 matrices:
                    System.out.println("Matrix 1 + Matrix 2 : ");
                    int[][] result1 = MatrixAddition(matrix1, matrix2);
                    PrintMatrix(result1);
                }
                case 2 -> {
//        for matrix 1:
                    System.out.println("(Matrix 1)Enter how many rows and columns you want: (R/C)");
                    int row1 = input.nextInt();
                    int col1 = input.nextInt();
                    int[][] matrix1 = InputMatrix(row1, col1, input);
                    System.out.println("Matrix A is: ");
                    PrintMatrix(matrix1);
//        for matrix 2:
                    System.out.println("(Matrix 2)Enter how many rows and columns you want: (R/C)");
                    int row2 = input.nextInt();
                    int col2 = input.nextInt();
                    int[][] matrix2 = InputMatrix(row2, col2, input);
                    System.out.println("Matrix B is: ");
                    PrintMatrix(matrix2);
//        for product of 2 matrices:
                    System.out.println("Matrix 1 * Matrix 2 : ");
                    int[][] result2 = Multiplication(matrix1, matrix2);
                    PrintMatrix(result2);
                }
                case 3 -> {
//        for matrix 1:
                    System.out.println("(Matrix 1) Enter how many rows and columns you want: (R/C)");
                    int row1 = input.nextInt();
                    int col1 = input.nextInt();
                    int[][] matrix1 = InputMatrix(row1, col1, input);
                    System.out.println("Matrix A is: ");
                    PrintMatrix(matrix1);
//        for matrix 2:
                    System.out.println("(Matrix 2) Enter how many rows and columns you want: (R/C)");
                    int row2 = input.nextInt();
                    int col2 = input.nextInt();
                    int[][] matrix2 = InputMatrix(row2, col2, input);
                    System.out.println("Matrix B is: ");
                    PrintMatrix(matrix2);
//        for subtract 2 matrices:
                    System.out.println("Matrix 1 - Matrix 2 : ");
                    int[][] result1 = MatrixSubtraction(matrix1, matrix2);
                    PrintMatrix(result1);
                }
                case 4 -> {
//        for input matrix:
                    System.out.println("Enter how many rows and columns you want: (R/C)");
                    int row = input.nextInt();
                    int col = input.nextInt();
                    int[][] matrix = InputMatrix(row, col, input);
                    System.out.println("Original Matrix is: ");
                    PrintMatrix(matrix);
//        Transpose:
                    System.out.println("transpose Matrix: ");
                    PrintMatrix(MatrixTranspose(matrix));

                }
                case 5 -> {
//        for input matrix:
                    System.out.println("Enter how many rows and columns you want: (R/C)");
                    int row = input.nextInt();
                    int col = input.nextInt();
                    int [][] matrix = InputMatrix(row, col, input);
                    System.out.println("Original Matrix is: ");
                    PrintMatrix(matrix);
//        Determinant:
                    System.out.println("Determinant: " + Determinant(matrix));

                }
            }
        }
        input.close();
    }

    public static int[][] InputMatrix(int row, int col, Scanner input) {
        System.out.println("input elements: ");

        int[][] matrix = new int[row][col];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        return matrix;
    }

    public static void PrintMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] Multiplication(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            throw new IllegalArgumentException("For Multiplication Col of Matrix 1 and Rows of Matrix 2 should be equal: ");
        }
        int[][] result = new int[matrix1.length][matrix2[0].length];
//        iterates over rows of Matrix 1:
        for (int i = 0; i < matrix1.length; i++) {
//        iterates over Columns of Matrix 2:
            for (int j = 0; j < matrix2[0].length; j++) {
//        iterates over Rows of Matrix 1 & Columns of Matrix 2:
                for (int k = 0; k < matrix2.length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static int[][] MatrixAddition(int matrix1[][], int matrix2[][]) {
        if (matrix1.length != matrix2.length) {
            throw new IllegalArgumentException("for addition you must input square matrix.");
        }
        int[][] result = new int[matrix1.length][matrix2.length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] MatrixSubtraction(int matrix1[][], int matrix2[][]) {
        if (matrix1.length != matrix2.length) {
            throw new IllegalArgumentException("for addition you must input square matrix.");
        }
        int[][] result = new int[matrix1.length][matrix2.length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] MatrixTranspose(int[][] matrix) {
//        Transpose = (matrix[0].length=columns)(matrix.length=rows)
        int[][] transpose = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }



    public static int Determinant(int[][] matrix) {
        int n = matrix.length;
        int det = 0;
        if (n == 1) {
            det = matrix[0][0];
        } else if (n == 2) {
            det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            for (int i = 0; i < n; i++) {
                int[][] submatrix = new int[n - 1][n - 1];
                for (int j = 1; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (k < i) {
                            submatrix[j - 1][k] = matrix[j][k];
                        } else if (k > i) {
                            submatrix[j - 1][k - 1] = matrix[j][k];
                        }
                    }
                }
                det += matrix[0][i] * Math.pow(-1, i) * Determinant(submatrix);
            }
        }
        return det;
    }
}


