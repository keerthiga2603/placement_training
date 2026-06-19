import java.util.*;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowf = new boolean[9][9];
        boolean[][] colf = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                int val = board[i][j] - '1';
                int boxidx = (i / 3) * 3 + (j / 3);

                if (rowf[i][val] || colf[j][val] || box[boxidx][val]) {
                    return false;
                }

                rowf[i][val] = true;
                colf[j][val] = true;
                box[boxidx][val] = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        ValidSudoku obj = new ValidSudoku();

        boolean ans = obj.isValidSudoku(board);

        System.out.println(ans);
    }
}