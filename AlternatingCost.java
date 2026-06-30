import java.util.*;

public class AlternatingCost {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            long A = sc.nextLong();
            long B = sc.nextLong();
            long X = sc.nextLong();
            long Y = sc.nextLong();

            long hx = Math.abs(X); // required horizontal displacement
            long vy = Math.abs(Y); // required vertical displacement

            long totalMoves = hx + vy;

            // Number of odd and even positions among the original moves
            long oddSlots = (totalMoves + 1) / 2;
            long evenSlots = totalMoves / 2;

            // Effective costs after allowing 3-move detours
            long oddHorizontal = Math.min(A, 3L * B);
            long evenHorizontal = Math.min(B, 3L * A);

            // Costs swap for vertical moves
            long oddVertical = evenHorizontal;
            long evenVertical = oddHorizontal;

            long hOdd, hEven;

            // Place horizontal moves in cheaper slots first
            if (oddHorizontal <= evenHorizontal) {
                hOdd = Math.min(hx, oddSlots);
                hEven = hx - hOdd;
            } else {
                hEven = Math.min(hx, evenSlots);
                hOdd = hx - hEven;
            }

            long vOdd = oddSlots - hOdd;
            long vEven = evenSlots - hEven;

            long ans = hOdd * oddHorizontal
                    + hEven * evenHorizontal
                    + vOdd * oddVertical
                    + vEven * evenVertical;

            System.out.println(ans);
        }

        sc.close();
    }
}