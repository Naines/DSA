public class test 
{
    static int MOD=1000000007;
    static int m=1000000007;
    
    static int modularMultiplication(int a, int b) 
    {
        a=a%m;b=b%m;
        long c= (1L*a*b)%m;
        return(int) c;
    }
    
    static int exp(int x, int n) {
        if (n == 0)
            return 1;
        else if (n % 2 == 0)
            return exp((x * x), n / 2);
        else
            return (x * exp((x * x), (n - 1) / 2));
    }
    
    static long modexp(long a, long n, int mod) {
        if (n == 0)
            return 1;
        else if (n % 2 == 0)
            return modexp((a * a) % mod, n / 2, mod);
        else
            return a * modexp((a * a) % mod, (n - 1) / 2, mod) % mod;
    }
    public static void main(String[] args) 
    {
        //test 1:
        // int a= 455799960;
        // int b= 5;
        // System.out.println(modularMultiplication(a, b));

        //test 2:
        //System.out.println(exp(5,5));

        //test 3:
        for(int i= 100;i<=1000000;i+=100000)
        {
            System.out.println(modexp(i,100,m));
        }
    }
    
    
   
}
