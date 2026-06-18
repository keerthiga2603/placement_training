import java.util.*;

public class Accomplice {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int d=sc.nextInt();
        int[][] arr=new int[n][2];
        int maximum=0;
        for(int i=0;i<n;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
            maximum=Math.max(maximum,arr[i][1]);
        }
        int[] res=new int[maximum+1];
        for(int i=0;i<n;i++){
            res[arr[i][0]]++;
            res[arr[i][1]-d+1]--;
        }
        int count=0;
        for(int j=1;j<maximum+1;j++){
            res[j]+=res[j-1];
            if (res[j]>=d){
                count++;
            }
        }
        System.out.println(count);

    }
}
