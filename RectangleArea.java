import java.util.*;

class RectFind {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int maximum = 0;
        int prod;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                int j = st.pop();

                if (st.isEmpty()) {
                    prod = i;
                } else {
                    prod = i - st.peek() - 1;
                }

                int curr = arr[j] * prod;
                maximum = Math.max(maximum, curr);
            }

            st.push(i);
        }

        while (!st.isEmpty()) {
            int ss = st.pop();

            if (st.isEmpty()) {
                maximum = Math.max(maximum, arr[ss] * n);
            } else {
                maximum = Math.max(maximum, arr[ss] * (n - st.peek() - 1));
            }
        }

        return maximum;
    }
}

public class RectangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Size of histogram
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Heights
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        RectFind obj = new RectFind();

        int ans = obj.largestRectangleArea(arr);

        System.out.println(ans);

        sc.close();
    }
}