public class StringWithout3a3b {
    public static void main(String[] args) {
        int a=1, b=1;
        int i=a, j=b;
        char first='a', second='b';
        StringBuffer sb=new StringBuffer();
        if(j>i){
            i=b;
            j=a;
            first='b';
            second='a';
        }
        
        
        while(i+j>0){
            
            if(i-->=j)   sb.append(first);
            System.out.println(first+" "+i);
            if(i-->0)   sb.append(first);
            System.out.println(second+" "+i);
            System.out.println();
            if(j-->0)   sb.append(second);
        }
        
        System.out.println(sb);
    }
}
