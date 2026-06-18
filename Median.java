import java.util.*;

class MedianFinder {
    PriorityQueue<Integer> l = new PriorityQueue<>(Collections.reverseOrder()); // max heap
    PriorityQueue<Integer> r = new PriorityQueue<>(); // min heap


    public void addNum(int num) {
        r.add(num);
        l.add(r.poll());

        if (l.size() - r.size() > 1) {
            r.add(l.poll());
        }
    }

    public double findMedian() {
        if (l.size() == r.size()) {
            return (l.peek() + r.peek()) / 2.0;
        }
        return l.peek();
    }
}

public class Median {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MedianFinder obj = new MedianFinder();

        
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int choice = sc.nextInt();

            if (choice == 1) {
                int num = sc.nextInt();
                obj.addNum(num);
            } else if (choice == 2) {
                System.out.println("Median = " + obj.findMedian());
            }
        }

        sc.close();
    }
}