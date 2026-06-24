import java.util.*;

public class SegmentTreeMinimum {
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int q=sc.nextInt();
        int newn=1;
        while(newn<n){
            newn=newn<<1;
        }
        //System.out.println("newtn : "+newn);
        long[] segment=new long[2*newn];
        Arrays.fill(segment,Long.MAX_VALUE);
        for (int i = newn ; i < n+newn; i++) {
            segment[i]=sc.nextLong();
        }
        
        
        n=newn;
        for(int i=n-1;i>0;i--){
            segment[i]=Math.min(segment[i*2],segment[i*2+1]);
        }
        

       
        int choice, pos, val,left,right;
        SegmentTreeMinimum st=new SegmentTreeMinimum();
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
    private void update(long[] segment, int pos,int val){
        segment[pos]=val;
        while(pos>1){
            pos=pos/2;
            segment[pos]=Math.min(segment[pos*2],segment[pos*2+1]);
        }
    }

    private long find(long[] segment, int nl, int nr, int node,int left, int right){
        if(nr<left || nl>right ){
            return Long.MAX_VALUE;
        }
        if(nl>=left && nr<=right){
            return segment[node];
        }
        int mid=(nl+nr)/2;
        return Math.min(find(segment, nl,mid,node*2,left,right),find(segment, mid+1,nr,node*2+1,left,right));

    }
}
