import java.util.ArrayList;

/**
 * Algorithm given here calculates factorizations of all numbers in the segment
 * [2;n] as a side effect, and that can be helpful in many practical
 * applications.
 * 
 * The weakness of the given algorithm is in using more memory than the classic
 * sieve of Eratosthenes': it requires an array of n numbers, while for the
 * classic sieve of Eratosthenes it is enough to have n bits of memory (which is
 * 32 times less).
 * 
 * Thus, it makes sense to use the described algorithm only until for numbers of
 * order 107 and not greater.
 */

 /**
  * the array store first prime factor of every composite number instead of 0/1/true false
  arr[]=               0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
  lp[](least prime):   0 0 0 0 2 0 2 0 2 3 2  0   2  0  2  3  2  0  2  0  2

  optimized by using only for odd nos.
  */
public class SieveLinear 
{
    static int max=10000;
    static ArrayList<Integer> primes=new ArrayList<>();
    static int lp[]=new int[max+1];
    static void initialize()
    {
        for(int i=2;i<=max;i++)
        {
            {
                if(lp[i]==0)
                {
                    lp[i]=i;
                    primes.add(i);
                }
                //now mark all multiples of i
                for(int j=0;j<primes.size();j++)
                {
                    if(primes.get(j)<=lp[i] && i*primes.get(j)<=max)
                    lp[i* primes.get(j)]=primes.get(j);

                }
            }

        }
        
    }
    
    static int pr[] = new int[10001];
    static int n = 10000;

    static void initailizeNormalSieve()
        {
            for(int i=2;i*i<=n;i++)
            {
                if(pr[i]==0)
                for(int j=i*i; j<=n;j+=i)
                pr[j]=1;
            }
        }
    public static void main(String[] args) 
    {
        double start=System.nanoTime();
        initialize();
        double end=System.nanoTime();

        System.out.println("time taken"+(start-end)/1e9);
        for (int i = 0; i < 20 ; i++)
            System.out.println(lp[i] + " "+i);
        
        start =System.nanoTime();
        initailizeNormalSieve();
        end= start = System.nanoTime();
        System.out.println("time taken" + (start - end) / 1e9);

        for(int i=0;i<20;i++)
        if(pr[i]==0)
        System.out.println(i);
    }
}
