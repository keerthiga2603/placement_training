import java.util.*;

public class ChalkboardMedian {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int a=sc.nextInt();
        PriorityQueue<Integer> minh=new PriorityQueue<>();
        PriorityQueue<Integer> maxh=new PriorityQueue<>(Collections.reverseOrder());

        minh.add(a);

        int q=sc.nextInt();

        for(int i=0;i<q;i++){
            minh.add(sc.nextInt());
            minh.add(sc.nextInt());

            maxh.add(minh.poll());
            maxh.add(minh.poll());

            while (maxh.size()>minh.size()+1){
                minh.add(maxh.poll());
            }

            System.out.println(maxh.peek());

        }

    }
}
