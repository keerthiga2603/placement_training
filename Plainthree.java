import java.util.*;

public class Plainthree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String string = sc.nextLine().trim();

        long[] left = new long[26];
        long[] right = new long[26];

        // Build right frequency
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            right[ch - 'a']++;
        }

        long counter = 0;

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            // right[ord(j)-97] -= 1
            right[ch - 'a']--;

            // arr = list(map(lambda x,y:x*y,left,right))
            // counter += sum(arr)
            long sum = 0;
            for (int j = 0; j < 26; j++) {
                sum += left[j] * right[j];
            }

            counter += sum;

            // left[ord(j)-97] += 1
            left[ch - 'a']++;
        }

        System.out.println(counter);

        sc.close();
    }
}