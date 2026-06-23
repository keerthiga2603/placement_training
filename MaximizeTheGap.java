import java.util.*;

public class MaximizeTheGap {
    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[][] arr=new int[n][2];
        int max=0;

        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            if(b>max){
                max=b;
            }
            arr[i][0]=a;
            arr[i][1]=b;
        }
        int maxx=max;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        // for(int y=0;y<n;y++){
        //     System.out.println(arr[y][0]+" "+arr[y][1]);
        // }
        int countk=0;
        int i=0;
        int min=0;
        //System.out.println(max+"00");

        int[][] res=new int[k][2];
        
        while(countk<k && i<n){
            int mid=min+(max-min)/2;
            //System.out.println(mid);
            res[countk][0]=arr[i][0];
            res[countk][1]=arr[i][1];
            countk++;
            
            //int i=0;
            for(int j=0;j<n;j++){   
                if(arr[j][0]>=mid+arr[i][1]){
                    res[countk][0]=arr[j][0];
            res[countk][1]=arr[j][1];
                    countk++;
                    i=j;
                }
            }
            if(countk==k){
                // for(int y:res){
                //     System.out.println("res:"+y);
                // }
                break;
            }else{
                countk=0;
                i=0;
                max=mid;
            }
           
            }
            
            int mindistance=maxx;
            //System.out.println(maxx);
            
            // for(int y=0;y<res.length;y++){
            //     System.out.println(res[y][0]+" "+res[y][1]);
            // }
            for(int x=0;x<res.length-1;x++){
                mindistance=Math.min(mindistance,res[x+1][0]-res[x][1]);
                if(mindistance==0){
                    System.out.print("-1");
                    return;
                }

            }
            
            System.out.println(mindistance);
        }

        




    }

