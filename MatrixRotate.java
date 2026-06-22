
import java.util.*;

class Result {


    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */
    public static void matrixRotation(List<List<Integer>> matrix, int r) {

        // Write your code here
        int rows = matrix.size();
        int cols = matrix.get(0).size();

        int a = 0;
        //int[][] array=new int[Math.min(rows,cols)/2][(2*rows)+(2*cols)-4];

        List<List<Integer>> result = new ArrayList<>();
        while (a < Math.min(rows, cols) / 2) {
            List<Integer> temp = new ArrayList<>();
            int i = a;
            int j = a;
            while (i < rows - a - 1) {

                temp.add(matrix.get(i).get(j));
                System.out.println(i + " " + matrix.get(i).get(j) + " " + j);
                i++;
            }

            while (j < cols - a - 1) {
                temp.add(matrix.get(i).get(j));
                System.out.println(i + " " + matrix.get(i).get(j) + " " + j);
                j++;
            }

            while (i > a) {
                temp.add(matrix.get(i).get(j));
                System.out.println(i + " " + matrix.get(i).get(j) + " " + j);
                i--;

            }

            while (j > a) {
                temp.add(matrix.get(i).get(j));
                System.out.println(i + " " + matrix.get(i).get(j) + " " + j);
                j--;
            }
            j++;

            result.add(temp);
            a++;
        }
        System.out.print(result + "\n");
        int i = 0;
        int rotations;
        while (i < result.size()) {

            List<Integer> layer = result.get(i);
            if (r % layer.size() == 0) {
                rotations = layer.size();
            } else {
                rotations = r % layer.size();
            }

            Collections.rotate(layer, rotations);
            i++;
        }
        System.out.println(result);

        int[][] rotated = new int[rows][cols];
        a = 0;
        
        while (a < Math.min(rows, cols) / 2) {
             List<Integer> layers = result.get(a);
             int idx=0;
            i = a;
            int j = a;
            while (i < rows - a - 1) {
                rotated[i][j] = layers.get(idx++);
                i++;
            }

            while (j < cols - a - 1) {
                rotated[i][j] = layers.get(idx++);
                j++;
            }

            while (i > a) {
                rotated[i][j] = layers.get(idx++);
                i--;
            }
            while (j > a) {
                rotated[i][j] = layers.get(idx++);
                j--;
            }
            a++;
        }
         for (int x = 0; x < rows; x++) {
                for (int y = 0; y < cols; y++) {
                    System.out.print(rotated[x][y] + " ");
                }
                System.out.println();
            }

    }

}

public class MatrixRotate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(sc.nextInt());
            }
            matrix.add(row);
        }

        Result.matrixRotation(matrix, r);

        sc.close();
    }
}
