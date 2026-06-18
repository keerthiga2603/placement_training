import java.util.*;

public class ConsHigh {
    public static void main(String[] ars){
        Scanner sc=new Scanner(System.in);
        Stack<Integer> st=new Stack<>();
        
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=n-1;i>=0;i--){
            //st.push(arr[i]);
            if(st.isEmpty()){
                System.out.print(-1+" ");
            }else if(st.peek()>=arr[i]){
                System.out.print(st.peek()+" ");
            }else{
                while(!st.isEmpty() && st.peek()<arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    System.out.print(-1+" ");
                }else{
                System.out.print(st.peek()+" ");
                }
            }
            st.push(arr[i]);


        }
    }
}
