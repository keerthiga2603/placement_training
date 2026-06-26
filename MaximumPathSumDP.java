import java.util.*;

public class MaximumPathSumDP{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] matrix=new int[n][n];
        for (int i = 0; i < n; i++) {
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
    
        int fmax,smax;
        for(int i=1;i<n;i++){
            fmax=matrix[i-1][0];
            smax=Integer.MIN_VALUE;

            for(int j=0;j<n;j++){
                if(fmax<matrix[i-1][j]){
                    smax=fmax;
                    fmax=matrix[i-1][j];
                }else if(smax<matrix[i-1][j]){
                    smax=matrix[i-1][j];
                }}
            for(int j=0;j<n;j++){

                if(matrix[i-1][j]==fmax){
                    matrix[i][j]+=smax;
                }else{
                    matrix[i][j]+=matrix[i-1][j];
                }
            }
            

        }
        System.out.println("THE ANSWER");
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                System.out.print(matrix[k][i]+" ");
            }
            System.out.println();
        }
        int maximum=Integer.MIN_VALUE;
        for(int j=0;j<n;j++){
            maximum=Math.max(maximum,matrix[n-1][j]);
        }
        System.out.println(maximum);
    }
}