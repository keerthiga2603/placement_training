import java.util.*;

public class CstandsForCenter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        long count=0L;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='C'){
                int m=Math.min(i,str.length()-1-i);
                count+=m+1;
            }
        }
        System.out.print(count);

    }
}
