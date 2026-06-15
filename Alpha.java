import java.util.*;

public class Alpha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().trim();

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        int maxLen = 0;
        int counter = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            boolean isVowel = false;
            for (char v : vowels) {
                if (v == ch) {
                    isVowel = true;
                    break;
                }
            }

            if (isVowel) {
                counter++;
            } else {
                counter--;
            }

            if (map.containsKey(counter)) {
                maxLen = Math.max(maxLen, i - map.get(counter));
            } else {
                map.put(counter, i);
            }
        }

        System.out.println(maxLen);

        sc.close();
    }
}