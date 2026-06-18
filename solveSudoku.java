import java.util.Scanner;

public class solveSudoku {

    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][] boxes = new boolean[9][9];

    public void solveSudoku(char[][] board) {

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int val = board[r][c] - '1';
                    int boxIdx = (r / 3) * 3 + (c / 3);

                    rows[r][val] = true;
                    cols[c][val] = true;
                    boxes[boxIdx][val] = true;
                }
            }
        }

        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int r, int c) {

        if (c == 9) {
            r++;
            c = 0;
        }

        if (r == 9) {
            return true;
        }

        if (board[r][c] != '.') {
            return backtrack(board, r, c + 1);
        }

        int boxIdx = (r / 3) * 3 + (c / 3);

        for (int num = 0; num < 9; num++) {

            if (!rows[r][num] && !cols[c][num] && !boxes[boxIdx][num]) {

                board[r][c] = (char) (num + '1');

                rows[r][num] = true;
                cols[c][num] = true;
                boxes[boxIdx][num] = true;

                if (backtrack(board, r, c + 1)) {
                    return true;
                }

                board[r][c] = '.';

                rows[r][num] = false;
                cols[c][num] = false;
                boxes[boxIdx][num] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] board = new char[9][9];

        for (int i = 0; i < 9; i++) {
            String row = sc.next();

            for (int j = 0; j < 9; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        solveSudoku solver = new solveSudoku();
        solver.solveSudoku(board);

        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}