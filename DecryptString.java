import java.util.*;

class Decrypt {
    public String freqAlphabets(String s) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty()) {
                st.push(s.charAt(i) - '0');
            } 
            else if (s.charAt(i) == '#') {
                int a = st.pop();
                int b = st.pop();

                int num = b * 10 + a;

                st.push(num);
            } 
            else {
                st.push(s.charAt(i) - '0');
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            int ch = st.pop();
            sb.append((char) (ch + 'a' - 1));
        }

        return sb.reverse().toString();
    }
}

public class DecryptString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        Decrypt obj = new Decrypt();

        System.out.println(obj.freqAlphabets(s));

        sc.close();
    }
}