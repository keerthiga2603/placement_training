import java.util.*;

public  class MultipleOfBase{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int dig=0;
        int rem=0;
        int tenpower=1;
        int base=2019;

        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        


        for(int i=str.length()-1;i>=0;i--){
            dig=str.charAt(i)-'0';
            //System.out.println(dig);
            rem=(rem+(dig*tenpower)%base)%base;
            tenpower=(tenpower*10)%base;
            if(map.containsKey(rem)){
                map.put(rem,map.get(rem)+1);
                count++;
            }else{
                map.put(rem,1);
            }

        }
        System.out.println(count);
    }
}