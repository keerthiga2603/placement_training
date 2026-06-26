import java.util.*;

public class TwoCurrencies{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int s=sc.nextInt();

        int[][] roads=new int[m][4];
        for(int i=0;i<m;i++){
            roads[i][0]=sc.nextInt();
            roads[i][1]=sc.nextInt();
            roads[i][2]=sc.nextInt();
            roads[i][3]=sc.nextInt();
            
        }
        int[][] exchange=new int[n+1][2];
        for(int j=1;j<=n;j++){
            exchange[j][0]=sc.nextInt();
            exchange[j][1]=sc.nextInt();
        }
        s=Math.min(s,2500);

        PriorityQueue<int[]> pq =
    new PriorityQueue<>((a,b)->Long.compare(a[0], b[0]));

        int[][] matrix=new int[n+1][2500+1];
        for(int[] mat:matrix){

            Arrays.fill(mat,Integer.MAX_VALUE);
        }
        matrix[1][s]=0;

        
        pq.offer(new int[]{0,1,s});

        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            if(cur[0] != matrix[cur[1]][cur[2]]) continue;
             int newSilver = Math.min(2500, cur[2] + exchange[cur[1]][0]);
            int newtime=cur[0]+exchange[cur[1]][1];
            if(matrix[cur[1]][newSilver]>newtime){
                matrix[cur[1]][newSilver]=newtime;
                pq.offer(new int[]{newtime,cur[1],newSilver});
            }
            int dest,redcost,timee;
            for(int k=0;k<m;k++){
                int from = roads[k][0];
    int to = roads[k][1];

    if(from != cur[1] && to != cur[1]) continue;

    if(from == cur[1])
        dest = to;
    else
        dest = from;
                    redcost=roads[k][2];
                    timee=roads[k][3]+cur[0];
                    if(cur[2]>=redcost){
                    if(matrix[dest][cur[2]-redcost]>timee){
                matrix[dest][cur[2]-redcost]=timee;
                pq.offer(new int[]{timee,dest,cur[2]-redcost});
                //pq.offer(new int[]{timee,cur[1],cur[2]-redcost});
            }}
        }
                }
            
        for(int i=2;i<=n;i++){
            int mint=Integer.MAX_VALUE;
            for(int j=0;j<=2500;j++){
                mint=Math.min(mint,matrix[i][j]);
            }
            System.out.println(mint);
        }

    }
}