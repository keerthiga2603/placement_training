import java.util.*;

public class NQueens {

    public void place(int row, int n,
                      boolean[] colf,
                      boolean[] d1f,
                      boolean[] d2f,
                      List<List<String>> ans,
                      char[][] board) {

        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {

            if (colf[col] || d1f[row + col] || d2f[n - 1 + col - row]) {
                continue;
            }

            // Place queen
            board[row][col] = 'Q';
            colf[col] = true;
            d1f[row + col] = true;
            d2f[n - 1 + col - row] = true;

            // Recurse
            place(row + 1, n, colf, d1f, d2f, ans, board);

            // Backtrack
            board[row][col] = '.';
            colf[col] = false;
            d1f[row + col] = false;
            d2f[n - 1 + col - row] = false;
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        boolean[] colf = new boolean[n];
        boolean[] d1f = new boolean[2 * n - 1];
        boolean[] d2f = new boolean[2 * n - 1];

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        place(0, n, colf, d1f, d2f, ans, board);

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

      
        int n = sc.nextInt();

        NQueens obj = new NQueens();

        List<List<String>> ans = obj.solveNQueens(n);

    

        for (List<String> solution : ans) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }

        System.out.println("Total solutions = " + ans.size());

        sc.close();
    }
}