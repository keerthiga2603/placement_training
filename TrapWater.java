import java.util.*;

class Trap {
    public int trap(int[] height) {
        int n = height.length;

        int[] leftht = new int[n];
        int[] rightht = new int[n];

        leftht[0] = height[0];
        rightht[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            leftht[i] = Math.max(height[i], leftht[i - 1]);
        }

        for (int j = n - 2; j >= 0; j--) {
            rightht[j] = Math.max(height[j], rightht[j + 1]);
        }

        int sum = 0;

        for (int k = 0; k < n; k++) {
            sum += Math.min(leftht[k], rightht[k]) - height[k];
        }

        return sum;
    }
}

public class TrapWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Enter size of array
        int n = sc.nextInt();

        int[] height = new int[n];

        // Enter heights
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        Trap obj = new Trap();

        int ans = obj.trap(height);

        System.out.println(ans);

        sc.close();
    }
}