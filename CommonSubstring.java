import java.util.*;
public class CommonSubstring {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        int maximum=0;

        int[][] matrix=new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    matrix[i][j]=matrix[i-1][j-1]+1;
                    maximum=Math.max(maximum,matrix[i][j]);
                    
                }
            }

        }

        System.out.println(maximum);
    }
}
