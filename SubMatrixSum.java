import java.util.*;

class NumMatrix {
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int j = 0;
        int i = 1;

        while (i <= matrix[0].length && matrix[0].length != 1) {
            if (i >= matrix[0].length) {
                i = 1;
                j++;
            }
            if (j == matrix.length) {
                break;
            }
            matrix[j][i] += matrix[j][i - 1];

            i++;
        }

        i = 0;
        j = 1;

        while (j <= matrix.length && matrix.length != 1) {
            if (j >= matrix.length) {
                j = 1;
                i++;
            }
            if (i == matrix[0].length) {
                break;
            }
            matrix[j][i] += matrix[j - 1][i];

            j++;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int a = (col1 > 0) ? matrix[row2][col1 - 1] : 0;
        int b = (row1 > 0) ? matrix[row1 - 1][col2] : 0;
        int c = (row1 > 0 && col1 > 0) ? matrix[row1 - 1][col1 - 1] : 0;
        int d = matrix[row2][col2];

        return d - a - b + c;
    }
}

public class SubMatrixSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input matrix dimensions
        System.out.print("Enter rows and columns: ");
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        System.out.println("Enter matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        NumMatrix obj = new NumMatrix(matrix);

        System.out.print("Enter number of queries: ");
        int q = sc.nextInt();

        while (q-- > 0) {
            System.out.print("Enter row1 col1 row2 col2: ");
            int row1 = sc.nextInt();
            int col1 = sc.nextInt();
            int row2 = sc.nextInt();
            int col2 = sc.nextInt();

            System.out.println("Sum = " +
                    obj.sumRegion(row1, col1, row2, col2));
        }

        sc.close();
    }
}