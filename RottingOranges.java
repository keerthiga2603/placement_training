import java.util.*;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int oranges = 0;
        Queue<int[]> q = new LinkedList<>();

        // Find all initially rotten oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                else if (grid[i][j] == 1) {
                    oranges++;
                }
            }
        }

        int min = 0;
        int[] dir = {0, 1, 0, -1, 0};

        while (!q.isEmpty() && oranges > 0) {

            int size = q.size();

            for (int s = 0; s < size; s++) {

                int[] curr = q.poll();

                for (int i = 0; i < 4; i++) {

                    int ar = curr[0] + dir[i];
                    int ac = curr[1] + dir[i + 1];

                    if (ar >= 0 && ar < grid.length &&
                        ac >= 0 && ac < grid[0].length &&
                        grid[ar][ac] == 1) {

                        grid[ar][ac] = 2;
                        q.add(new int[]{ar, ac});
                        oranges--;
                    }
                }
            }

            min++;
        }

        return (oranges > 0) ? -1 : min;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] grid = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        RottingOranges obj = new RottingOranges();

        System.out.println(obj.orangesRotting(grid));

        sc.close();
    }
}