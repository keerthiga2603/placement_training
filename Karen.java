import java.util.*;

public class Karen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int MAX = 200000;

        int[] arr = new int[MAX + 2];

        int r = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();

        int[][] recipes = new int[r][2];
        int[][] queries = new int[q][2];

        for (int i = 0; i < r; i++) {
            recipes[i][0] = sc.nextInt();
            recipes[i][1] = sc.nextInt();
        }

        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        // Difference array
        for (int i = 0; i < r; i++) {
            arr[recipes[i][0]] += 1;
            arr[recipes[i][1] + 1] -= 1;
        }

        // Prefix sum -> coverage count
        for (int j = 1; j < MAX + 2; j++) {
            arr[j] += arr[j - 1];
        }

        int[] res = new int[MAX + 2];

        // Good temperatures
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= k) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
        }

        // Prefix sum of good temperatures
        for (int i = 1; i < res.length; i++) {
            res[i] += res[i - 1];
        }

        // Answer queries
        for (int i = 0; i < q; i++) {
            System.out.println(
                res[queries[i][1]] - res[queries[i][0] - 1]
            );
        }

        sc.close();
    }
}