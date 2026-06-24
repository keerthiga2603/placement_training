import java.io.*;

public class CSESegmentTreeSum {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long num = 0;
            while (c > ' ') {
                num = num * 10 + (c - '0');
                c = read();
            }

            return num * sign;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner sc = new FastScanner();

        int n = (int) sc.nextLong();
        int q = (int) sc.nextLong();

        int newn = 1;
        while (newn < n) {
            newn <<= 1;
        }

        long[] segment = new long[2 * newn];

        for (int i = newn; i < n + newn; i++) {
            segment[i] = sc.nextLong();
        }

        n = newn;

        for (int i = n - 1; i > 0; i--) {
            segment[i] = segment[i * 2] + segment[i * 2 + 1];
        }

        

        CSESegmentTreeSum st = new CSESegmentTreeSum();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {

            int choice = (int) sc.nextLong();

            if (choice == 1) {

                int pos = (int) sc.nextLong();
                long val = sc.nextLong();

                st.update(segment, n - 1 + pos, val);

            } else {

                int left = (int) sc.nextLong();
                int right = (int) sc.nextLong();

                sb.append(st.find(segment, 1, n, 1, left, right))
                  .append('\n');
            }
        }

        System.out.print(sb);
    }

    private void update(long[] segment, int pos, long val) {

        segment[pos] = val;

        while (pos > 1) {
            pos /= 2;
            segment[pos] = segment[pos * 2] + segment[pos * 2 + 1];
        }
    }

    private long find(long[] segment, int nl, int nr,
                      int node, int left, int right) {

        if (nr < left || nl > right) {
            return 0;
        }

        if (nl >= left && nr <= right) {
            return segment[node];
        }

        int mid = (nl + nr) / 2;

        return find(segment, nl, mid, node * 2, left, right)
             + find(segment, mid + 1, nr, node * 2 + 1, left, right);
    }
}