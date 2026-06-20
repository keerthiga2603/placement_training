import java.util.*;

public class Largestisland {

    public static int dfs(int[][] grid, int i, int j, HashMap<Integer, Integer> map, int island) {
        int count = 0;

        if (grid[i][j] != 1) {
            return 0;
        }

        if (grid[i][j] == 1) {
            grid[i][j] = island;
            count += 1;

            if (i > 0) {
                count += dfs(grid, i - 1, j, map, island);
            }
            if (j > 0) {
                count += dfs(grid, i, j - 1, map, island);
            }
            if (i < grid.length - 1) {
                count += dfs(grid, i + 1, j, map, island);
            }
            if (j < grid.length - 1) {
                count += dfs(grid, i, j + 1, map, island);
            }
        }

        return count;
    }

    public static int largestIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int island = 2;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                int count = dfs(grid, i, j, map, island);
                island++;

                if (count != 0) {
                    map.put(island - 1, count);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        int maxvalue = (map.isEmpty()) ? 0 : Collections.max(map.values());

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 0) {

                    if (i > 0 && grid[i - 1][j] > 1) {
                        set.add(grid[i - 1][j]);
                    }
                    if (i < rows - 1 && grid[i + 1][j] > 1) {
                        set.add(grid[i + 1][j]);
                    }
                    if (j > 0 && grid[i][j - 1] > 1) {
                        set.add(grid[i][j - 1]);
                    }
                    if (j < cols - 1 && grid[i][j + 1] > 1) {
                        set.add(grid[i][j + 1]);
                    }

                    int ct = 1;

                    for (int x : set) {
                        if (map.containsKey(x)) {
                            ct += map.get(x);
                        }
                    }

                    maxvalue = Math.max(maxvalue, ct);
                }

                set.clear();
            }
        }

        return maxvalue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[][] grid = new int[n][n];

        System.out.println("Enter the grid:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println("Largest Island = " + largestIsland(grid));

        sc.close();
    }
}