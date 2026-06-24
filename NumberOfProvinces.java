import java.util.*;

class Provinces {
    public int findCircleNum(int[][] isConnected) {
        int[] setarr = new int[isConnected.length];

        for (int i = 0; i < isConnected.length; i++) {
            setarr[i] = i;
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    union(setarr, i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();

        for (int i : setarr) {
            set.add(find(setarr, i));
        }

        return set.size();
    }

    private int find(int[] setarr, int i) {
        if (setarr[i] == i) {
            return i;
        }
        return setarr[i] = find(setarr, setarr[i]);
    }

    private void union(int[] setarr, int i, int j) {
        int pi = find(setarr, i);
        int pj = find(setarr, j);

        if (pi != pj) {
            setarr[pi] = pj;
        }
    }
}

public class NumberOfProvinces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] isConnected = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isConnected[i][j] = sc.nextInt();
            }
        }

        Provinces sol = new Provinces();
        System.out.println(sol.findCircleNum(isConnected));

        sc.close();
    }
}