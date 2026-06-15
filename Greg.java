import java.util.*;

public class Greg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();   // n
        int y = sc.nextInt();   // m
        int z = sc.nextInt();   // k

        // Initial array
        long[] ques = new long[x];
        for (int i = 0; i < x; i++) {
            ques[i] = sc.nextLong();
        }

        // Operations
        int[][] op = new int[y][3];
        for (int i = 0; i < y; i++) {
            op[i][0] = sc.nextInt();
            op[i][1] = sc.nextInt();
            op[i][2] = sc.nextInt();
        }

        // Queries
        int[][] queries = new int[z][2];
        for (int i = 0; i < z; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        // Difference array for operation counts
        long[] arr = new long[y + 1];

        for (int i = 0; i < z; i++) {
            arr[queries[i][0] - 1] += 1;
            arr[queries[i][1]] -= 1;
        }

        // Prefix sum to get how many times each operation is applied
        for (int i = 1; i < y; i++) {
            arr[i] += arr[i - 1];
        }

        // Difference array for the original array
        long[] res = new long[x + 1];

        for (int i = 0; i < y; i++) {
            long value = (long) op[i][2] * arr[i];

            res[op[i][0] - 1] += value;
            res[op[i][1]] -= value;
        }

        // Prefix sum to get final increments
        for (int i = 1; i <= x; i++) {
            res[i] += res[i - 1];
        }

        // Final answer
        for (int i = 0; i < x; i++) {
            System.out.print(ques[i] + res[i]);

            if (i != x - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        sc.close();
    }
}