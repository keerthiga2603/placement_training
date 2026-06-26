import java.util.*;

public class SecondMax {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int fmax=arr[0];
        int smax=Integer.MIN_VALUE;
        for(int j=1;j<n;j++){
            if(fmax<arr[j]){
                smax=fmax;
                fmax=arr[j];

            }else if(smax<arr[j]){
                smax=arr[j];
            }
        }
        System.out.println(fmax+" "+smax);

    }
}
