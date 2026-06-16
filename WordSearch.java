import java.util.Scanner;

public class WordSearch {

    boolean dfs(char[][] board, boolean[][] visited,
                int row, int col, int ci, String word) {

        if (ci == word.length()) {
            return true;
        }

        if (row >= 0 && col >= 0 &&
            row < board.length && col < board[0].length &&
            !visited[row][col] &&
            board[row][col] == word.charAt(ci)) {

            visited[row][col] = true;

            boolean found =
                    dfs(board, visited, row - 1, col, ci + 1, word) ||
                    dfs(board, visited, row, col - 1, ci + 1, word) ||
                    dfs(board, visited, row + 1, col, ci + 1, word) ||
                    dfs(board, visited, row, col + 1, ci + 1, word);

            if (found) {
                return true;
            }

            visited[row][col] = false;   // backtracking
        }

        return false;
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j] == word.charAt(0)) {

                    boolean result = dfs(board, visited, i, j, 0, word);

                    if (result) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input rows and columns
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        char[][] board = new char[rows][cols];

        // Input board
        for (int i = 0; i < rows; i++) {
            String s = sc.next();

            for (int j = 0; j < cols; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        // Input word to search
        String word = sc.next();

        WordSearch obj = new WordSearch();

        boolean ans = obj.exist(board, word);

        System.out.println(ans);

        sc.close();
    }
}