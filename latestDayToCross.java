import java.util.*;

public class latestDayToCross {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter row and col: ");
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] cells = new int[row * col][2];

        System.out.println("Enter " + (row * col) + " pairs of cells:");

        for (int i = 0; i < row * col; i++) {
            cells[i][0] = sc.nextInt();
            cells[i][1] = sc.nextInt();
        }

        LatestDay sol = new LatestDay();

        int ans = sol.latestDayToCross(row, col, cells);

        System.out.println("Answer = " + ans);

        sc.close();
    }
}

class LatestDay {
    int[][] diff = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,1},{-1,1},{1,-1}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int[] setarr = new int[row * col + 2];
        int day = 0;
        boolean[] water = new boolean[row * col + 2];

        for (int j = 0; j < row * col + 2; j++) {
            setarr[j] = j;
        }

        for (int[] cell : cells) {
            int i = gci(col, cell[0] - 1, cell[1] - 1);
            water[i] = true;

            if (cell[1] - 1 == 0) {
                union(setarr, i, 0);
            }

            if (cell[1] - 1 == col - 1) {
                union(setarr, row * col + 1, i);
            }

            for (int[] d : diff) {
                int ar = cell[0] - 1 + d[0];
                int ac = cell[1] - 1 + d[1];

                if (ar >= 0 && ac >= 0 && ar < row && ac < col && water[gci(col, ar, ac)]) {
                    union(setarr, i, gci(col, ar, ac));
                }
            }

            day++;

            if (find(setarr, 0) == find(setarr, row * col + 1)) {
                return day - 1;
            }
        }

        return day - 1;
    }

    public int find(int[] setarr, int i) {
        if (i != setarr[i]) {
            setarr[i] = find(setarr, setarr[i]);
        }
        return setarr[i];
    }

    public void union(int[] setarr, int i, int j) {
        int pi = find(setarr, i);
        int pj = find(setarr, j);

        if (pi != pj) {
            setarr[pi] = pj;
        }
    }

    public int gci(int col, int r, int c) {
        return (r * col) + c + 1;
    }
}