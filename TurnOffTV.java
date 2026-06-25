import java.util.*;

public class TurnOffTV {

    public int find(int[] segment, int left, int right,int nl,int nr,int node){
        if(nr<left || nl>right){
            return Integer.MAX_VALUE;
        }
        if(nl>=left && nr<=right){
            return segment[node];
        }
        int mid=(nl+nr)/2;
        return Math.min(find(segment,left,right,nl,mid,node*2),find(segment,left,right,mid+1,nr,node*2+1));
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[][] arr=new int[n][2];
        List<Integer> dup=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        set.add(0);
        
        for(int i=0;i<n;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
            
            set.add(arr[i][0]);
            set.add(arr[i][1]);
            
            set.add(arr[i][1]+1);
        
        }
        for(int j:set){
            dup.add(j);
        }
        Collections.sort(dup);
        System.out.println(dup);
        
        HashMap<Integer, Integer> compress = new HashMap<>();

        for (int i = 0; i < dup.size(); i++) {
            compress.put(dup.get(i), i);
        }
        int[] pre=new int[dup.size()];
        for(int[] a:arr){
            pre[compress.get(a[0])]++;
            pre[compress.get(a[1] + 1)]--;
        }
        System.out.println("array start");
        for(int j:pre){
            System.out.print(j+" ");
        }
        
        for(int i=1;i<dup.size();i++){
            pre[i]+=pre[i-1];
        }

        System.out.println("array start");
        for(int j:pre){
            System.out.print(j+" ");
        }
        System.out.println();

        int p=pre.length-1;
        System.out.println(p);
        int pp=1;
        while(pp<p){
            pp=pp<<1;
        }
        System.out.println(pp);

        int[] segment=new int[2*pp];
        Arrays.fill(segment,Integer.MAX_VALUE);
        for(int i=0;i<p;i++){
            segment[pp+i]=pre[i];
        }
        for (int k:segment){
            System.out.print(k+" ");
        }
        
        p=pp;
        for(int j=p-1;j>0;j--){
            segment[j]=Math.min(segment[j*2],segment[j*2+1]);
        }

        for (int k:segment){
            System.out.print(k+" ");
        }
        boolean found=false;
        TurnOffTV turn=new TurnOffTV();
        System.out.println("answer is: ");

            for (int i = 0; i < n; i++) {

            int left = compress.get(arr[i][0]);
            int right = compress.get(arr[i][1] + 1) - 1;

            int minimum = turn.find(
                    segment,
                    left,
                    right,
                    0,
                    pp - 1,
                    1
            );
            if(minimum>1){
                System.out.println(i+1);
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("-1");
        }
        
    }
    
}
