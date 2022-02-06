public class findOnlySetBit 
{
    static boolean pwr2(int n)
    {
        if(n>0 && (n&(n-1))==0)
        return true;
        else return false;
    }
    static int find(int n)
    {
        if(!pwr2(n))
        return -1;
        int c=0;
        while(n>0)
        {
            n=n>>1;
            c++;
        }
        return c;
    }
    static int find2(int n)
    {
        int pos=(int)(Math.log(n)/Math.log(2));
        return (n>0 && (n&(n-1))==0)? 1+pos : -1;
    }
    public static void main(String[] args) {
        int n=32;
        System.out.println(find(n));
        System.out.println(find2(n));
    }
}
