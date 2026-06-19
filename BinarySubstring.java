import java.util.*;

public class BinarySubstring {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine().trim();

        int n=s.length();

        for(int mask=0;mask<(1<<n);mask++){
            for(int i=0;i<n;i++){
                if ((mask&(1<<n-1-i))!=0){
                    System.out.print(s.charAt(i));

                }           
             }
            System.out.println();
        }
    }
}
