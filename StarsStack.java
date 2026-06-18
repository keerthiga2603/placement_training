import java.util.*;

class Solution {
    public String removeStars(String s) {
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                stk.push(s.charAt(i));
            } else {
                if(!stk.isEmpty()) stk.pop();
                else{
                    return "-1";
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        return sb.reverse().toString();
    }
}

public class StarsStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        String s = sc.nextLine();

        Solution obj = new Solution();

        String ans = obj.removeStars(s);

        System.out.println(ans);

        sc.close();
    }
}