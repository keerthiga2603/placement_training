
import java.util.*;

public class CVariety {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<long[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new long[]{sc.nextLong(), sc.nextLong()});
        }
        //list.sort((a, b) -> b[1] - a[1]);
        list.sort((a, b) -> Long.compare(b[1], a[1]));

        int picked = 0;
        int cpicked = 0;
        long maxval = 0;
        boolean[] visited = new boolean[n];
        ArrayList<Long> colors = new ArrayList<>();

        for (int i=0;i<list.size();i++) {
            long[] l = list.get(i);
            if (cpicked < m) {
                if (!colors.contains(l[0])) {

                    colors.add(l[0]);
                    maxval += l[1];
                    visited[i] = true;
                    cpicked++;
                    picked++;
                }
            } else {
                break;
            }

        }

        for (int j=0;j<list.size();j++) {
            long[] l = list.get(j);
            if (picked < k) {
                if (!visited[j]) {

                    picked++;
                    colors.add(l[0]);
                    maxval += l[1];
                    visited[j] = true;
                }

            } else {
                break;
            }
        }

        System.out.println(picked+" "+cpicked+" "+maxval);
        System.out.println(colors);
    }

}



