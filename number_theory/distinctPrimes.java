import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class distinctPrimes 
{
    static int sieve[];
    static ArrayList<Integer> result = new ArrayList<>();
    static void sieve(int n)
    {
        sieve=new int[n+1];
        sieve[0]=1;
        sieve[1]=1;
        for (int i = 2; i < n; i++) 
        {
            if (sieve[i] == 0) 
            {
                sieve[i] = 1;
                for (int j = i * 2; j < n; j = j + i) 
                {
                    sieve[j] -= 1;
                    if ((sieve[j] + 3) == 0)
                        result.add(j);
                }
            }
            Collections.sort(result);
        }
    }
    public static void main(String[] args) throws Exception
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            int n = 3000;
            sieve(n);
            
            int t = sc.nextInt();
            while (t-- > 0) {
                int k = sc.nextInt();
                System.out.println(result.get(k - 1));
            }
            sc.close();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
       
    }
    
}
