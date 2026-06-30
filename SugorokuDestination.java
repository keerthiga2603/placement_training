import java.util.*;

public class SugorokuDestination {

    public int find(int[] arr, int[] dp,int a){

        if(a==arr[a]){ 
            return a;
        }
        dp[a]=find(arr,dp,arr[a]);

        return dp[a];
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[] arr=new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i]=sc.nextInt();
        }
        int[] dp=new int[n+1];
        SugorokuDestination sd=new SugorokuDestination();

        Arrays.fill(dp,-1);
        for(int k=1;k<=n;k++){
            if(dp[k]==-1){
                dp[k]=sd.find(arr,dp,k);
            }
        }

        for(int j=1;j<=n;j++){
            System.out.print(dp[j]+" ");
            }
        

    }
}
