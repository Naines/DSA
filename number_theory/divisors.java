import java.util.ArrayList;
import java.util.Scanner;

public class divisors 
{
    static ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
    static long modexp(long a,long n,int mod)
    {
        if(n==0)
        return 1;
        else if(n%2==0)
        return modexp((a*a)%mod,n/2,mod);
        else 
        return a*modexp((a*a)%mod,(n-1)/2,mod)%mod ;
    }
    static void sieve(int n)
    {
        for(int i=0;i<=n;i++)
        {
            arr.add(new ArrayList<>());
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=i;j<=n;j+=i)
            {
                arr.get(j).add(i);
            }
        }

    }
    public static void main(String[] args)throws Exception
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            //long start=System.nanoTime();
            int n=100000000;
            int mod=1000000007;
            sieve(n);
            int t=sc.nextInt();
            while(t-->0)
            {
                int a = sc.nextInt(), p = sc.nextInt();
                int len = arr.get(a).size();
                long res = 0;
                for (int i = 0; i < len; i++) {
                    //System.out.print(arr.get(a).get(i) + " ");
                    res = (res + modexp(arr.get(a).get(i), p, mod)) % mod;
                }
                System.out.println(res);
            }
            //long end = System.nanoTime();
            
            //System.out.println((end-start)/1000000000.0);
            sc.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }
}
