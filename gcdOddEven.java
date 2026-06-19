public class gcdOddEven {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int gcdOfOddEvenSums(int n) {
        int oddsum = 0;
        int evensum = 0;
        int i = 1;

        while (i <= 2 * n) {
            if (i % 2 == 0) {
                evensum += i++;
            } else {
                oddsum += i++;
            }
        }

        return gcd(evensum, oddsum);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(gcdOfOddEvenSums(n));
    }
}