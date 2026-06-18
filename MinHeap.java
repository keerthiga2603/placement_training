import java.util.*;

public class MinHeap {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int sum=0;
        int n=sc.nextInt();

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int i=0;i<n;i++){
            int x= sc.nextInt();
            pq.add(x);

        }

        while(pq.size()>1){
            int curr=pq.poll()+pq.poll();
            sum+=curr;
            pq.add(curr);
        }
        System.out.println(sum);
    }
}
