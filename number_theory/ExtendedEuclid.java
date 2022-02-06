public class ExtendedEuclid 
{
    static int d, x , y ;
    static void gcd(int a, int b)
    {
        if(a==0)
        {
            d=b;
            x=0;
            y=1;
        }
        else
        {
            gcd(b%a,a);
            int tmp=y;
            y=x;
            x=tmp-(b/a)*y;
        }
    }
    public static void main(String[] args) 
    {
        
        int a=10, b=16;
        gcd(a,b);
        System.out.println(a+"*"+x+"+ "+b+"*"+y+"= "+d );
    }
    
}
