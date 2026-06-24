import java.util.*;

public class SegmentTreeSum {
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int newn=1;
        while(newn<n){
            newn=newn<<1;
        }
        System.out.println("newtn : "+newn);
        int[] segment=new int[2*newn];
        
        for (int i = newn ; i < n+newn; i++) {
            segment[i]=sc.nextInt();
        }
        
        n=newn;
        for(int i=n-1;i>0;i--){
            segment[i]=segment[i*2]+segment[i*2+1];
        }
        

        int q=sc.nextInt();
        int choice, pos, val,left,right;
        SegmentTreeSum st=new SegmentTreeSum();
        for(int i=0;i<q;i++){
            choice=sc.nextInt();
            if(choice==1){
                pos=sc.nextInt();
                val=sc.nextInt();
                st.update(segment,n-1+pos,val);
            }else{
                left=sc.nextInt();
                right=sc.nextInt();
                System.out.println(st.find(segment,1,n, 1,left,right));
                
            }
        }

        
    }
    private void update(int[] segment, int pos,int val){
        segment[pos]=val;
        while(pos>1){
            pos=pos/2;
            segment[pos]=segment[pos*2]+segment[pos*2+1];
        }
    }

    private int find(int[] segment, int nl, int nr, int node,int left, int right){
        if(nr<left || nl>right ){
            return 0;
        }
        if(nl>=left && nr<=right){
            return segment[node];
        }
        int mid=(nl+nr)/2;
        return find(segment, nl,mid,node*2,left,right)+ find(segment, mid+1,nr,node*2+1,left,right);

    }
}
