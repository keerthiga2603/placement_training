import java.util.*;

public class FindingUnique {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] arr=new int[n];
        int fres=0;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            fres=fres^arr[i];
        }
        int bit = fres & (-fres);

        int unique1 = 0;
        int unique2 = 0;

        // Divide into two groups
        for (int num : arr) {
            if ((num & bit) != 0)
                unique1 ^= num;
            else
                unique2 ^= num;
        }

        System.out.println("Unique elements are:");
        System.out.println(unique1);
        System.out.println(unique2);

        
    }
}
