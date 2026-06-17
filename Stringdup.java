import java.util.*;

public class Stringdup {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int count=1;

        for (int i=1;i<s.length();i++){
            if (s.charAt(i)==s.charAt(i-1)){
                count++;
            }else{
                System.out.print(s.charAt(i-1)+""+count);
                count=1;
            }

        }
        System.out.print(s.charAt(s.length()-1)+""+count);
    }
}