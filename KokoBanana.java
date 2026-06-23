import java.util.*;

class Koko {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int maximum = 0;

        for (int j : piles) {
            maximum = Math.max(maximum, j);
        }

        int ans = maximum;

        while (min <= maximum) {
            long sum = 0;
            int mid = min + (maximum - min) / 2;

            for (int i : piles) {
                sum += (i + mid - 1) / mid;   // ceil(i/mid)
            }

            if (sum <= h) {
                ans = mid;
                maximum = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return ans;
    }
}

public class KokoBanana {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of piles
        int n = sc.nextInt();

        int[] piles = new int[n];

        // Input pile sizes
        for (int i = 0; i < n; i++) {
            piles[i] = sc.nextInt();
        }

        // Input h
        int h = sc.nextInt();

        Koko sol = new Koko();
        int answer = sol.minEatingSpeed(piles, h);

        System.out.println(answer);

        sc.close();
    }
}