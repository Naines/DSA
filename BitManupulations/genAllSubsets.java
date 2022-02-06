import java.util.TreeSet;

public class genAllSubsets 
{
    static TreeSet<String> t=new TreeSet<>();
    static void print(String str, int n)
    {
        char ch[]=str.toCharArray();
        int i=1;
        String s="";
        while(n>0)
        {
            if((n&1)==1)
            s=s+ch[i-1];
            i++;
            n=n>>1;
        }
        t.add(s);
    }
    public static void main(String[] args) 
    {
        String str="abc";
        int n=str.length();
        int range= (1<<n)-1;
        for(int i=1;i<=range;i++)
        print(str, i);
        for(String s: t)
        System.out.println(s);
    }
    
}
