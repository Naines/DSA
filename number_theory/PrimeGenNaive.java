import java.util.Scanner;

//good for 10^6-10^7(hardly)
//for greater use prime sieve
public class PrimeGenNaive 
{
    static boolean sieve[];
    static void sieve(int n){
        sieve=new boolean[n+1];
        sieve[0]=true;
        sieve[1]=true;
        for(int i=2;i*i<=n;i++)
        {
            for(int j=i*i;j<=n;j+=i)
            {
                sieve[j]=true;
            }
        }
    }
    public static void main(String[] args) 
    {
        int size= 10000000;
        sieve(size);
        System.out.println("here");
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            for(int i=a;i<=b;i++)
            {
                if(sieve[i]==false)
                System.out.println(i);
            }
            System.out.println();
        }
        sc.close();
    }
}
