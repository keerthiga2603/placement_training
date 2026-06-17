import java.util.*;

public class ShortestPathAllKeys {

    public int shortestPathAllKeys(String[] grid) {
        int r = grid.length, c = grid[0].length();
        int keys = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                char ch = grid[row].charAt(col);

                if (ch == '@') {
                    q.add(new int[]{row, col, 0, 0});
                }

                if (ch >= 'a' && ch <= 'f') {
                    keys++;
                }
            }
        }

        boolean[][][] vis = new boolean[r][c][1 << keys];

        int[] start = q.peek();
        vis[start[0]][start[1]][0] = true;

        int[] diff = {0, -1, 0, 1, 0};

        while (!q.isEmpty()) {
            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];
            int kst = cell[2];
            int moves = cell[3];

            for (int i = 0; i < 4; i++) {
                int ar = row + diff[i];
                int ac = col + diff[i + 1];

                if (ar < 0 || ar >= r || ac < 0 || ac >= c)
                    continue;

                char cc = grid[ar].charAt(ac);

                if (cc == '#')
                    continue;

                int ast = kst;

                if (cc >= 'a' && cc <= 'f') {
                    ast |= (1 << (cc - 'a'));
                }

                if (cc >= 'A' && cc <= 'F') {
                    if ((ast & (1 << (cc - 'A'))) == 0)
                        continue;
                }

                if (ast == (1 << keys) - 1)
                    return moves + 1;

                if (!vis[ar][ac][ast]) {
                    vis[ar][ac][ast] = true;
                    q.add(new int[]{ar, ac, ast, moves + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine();
        }

        ShortestPathAllKeys obj = new ShortestPathAllKeys();

        int ans = obj.shortestPathAllKeys(grid);

        System.out.println(ans);

        sc.close();
    }
}