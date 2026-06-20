import java.util.*;

public class HugePile {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        

        int[][] tests=new int[n][2];

        for(int i=0;i<n;i++){
            tests[i][0]=sc.nextInt();
            tests[i][1]=sc.nextInt();
        }
        int minv,maxv,level;

        for(int i=0;i<n;i++){
            minv=tests[i][0];
            maxv=tests[i][0];
            level=0;

            while(minv>tests[i][1] && maxv>tests[i][1]){
                if(maxv%2!=0){
                    maxv=(maxv/2)+1;
                }else{
                    maxv/=2;
                }
             
                minv=minv/2;
                level++;
                
            }

            if(minv==tests[i][1] || maxv==tests[i][1]){
                System.out.println(level);
                
            }else{

            System.out.println(-1);
            }
            
            

        
        }
    }
}
