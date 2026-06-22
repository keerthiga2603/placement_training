import java.util.*;

class PigeonHole{

    public int transfer (int[] nests,int[] location, int a, int b,int count){
        nests[location[a]]--;
        if(nests[location[a]]==1){
            count--;
        }
        nests[b]++;
        if(nests[b]==2){
            count++;
        }
        location[a]=b;
       
        return count;

    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int pigeoncount=sc.nextInt();
        int queries=sc.nextInt();
        
        int[] nests= new int[pigeoncount];
        int[] location=new int[pigeoncount];
        for(int i=0;i<pigeoncount;i++){
            nests[i]=1;
            location[i]=i;
        }
        PigeonHole ph=new PigeonHole();
        int count=0;

        for(int i=0;i<queries;i++){
            int s=sc.nextInt();
            if(s==2){
                System.out.println(count);
            }else{
                int a=sc.nextInt();
                int b=sc.nextInt();
                count= ph.transfer(nests,location,a-1,b-1,count);
            }
            
        }

        
    }
}