import java.util.*;

public class TallestAtMoment {
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int till=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int ht=sc.nextInt();
            int time=sc.nextInt();
            list.add(new int[] {ht,time});
            
        }
        list.sort((a, b) -> b[0] - a[0]);
        for(int[] f:list){
            System.out.println(f[0]+" "+f[1]);
        }
        for(int[] l: list){
            if(till>=l[1]){
                continue;
            }else{
            map.put(l[0],l[1]);
            till=l[1];
            }
        }
            
        TallestAtMoment obj = new TallestAtMoment();
        int q=sc.nextInt();
        System.out.println(map);
        
        for(int i=0;i<q;i++){
            obj.valuate(sc.nextInt(),map);
        }
    
    }
    public void valuate(int query,HashMap<Integer,Integer> map){
        int immin=Integer.MAX_VALUE;
        for (int m : map.values()) {
            if(query>=m){
                continue;
            }else{
                
                immin=Math.min(immin,m);
                
            }
        }
        
        for (int key:map.keySet()){
           
            if(map.get(key)==immin){
                System.out.println(key);
                return;
               
            }

        }
        System.out.println("-1");
        return;
        
        //  long tallest= Collections.max(map.keySet());
        //  while(!map.isEmpty()){
        //  if(query<map.get(tallest)){
        //     System.out.println(tallest);
        //     return;
        
        //  }else{
        //     map.remove(tallest);
        //     tallest= Collections.max(map.keySet());
        //  }
        // }
        // System.out.print("-1");

    }
}
