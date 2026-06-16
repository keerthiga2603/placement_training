import java.util.*;

public class SwapToGather {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str= sc.next();
        
        int n=str.length();
        int left=0;
        int right=0;
        int swaps=0;
        for(int i=0;i<n;i++){
            if (str.charAt(i)=='1'){
                right+=1;
            }
        }
        
        for (int j=0;j<n;j++){
            if (str.charAt(j)=='1'){
                left+=1;
                right-=1;
            }
            else{
                swaps+=Math.min(left,right);
            }
        }

        System.out.println(swaps);
    }
}
