import java.util.Arrays;
import java.util.Scanner;

/**
 * SmallestStringWithAGiven
 */
public class SmallestStringWithAGiven 
{
    static void solve(int n, int k)
    {
        char ch[]=new char[n];
        Arrays.fill(ch, 'a');
        k-=n;
        for(int i=n-1;i>=0;i--)
        {
            ch[i]+=Math.min(k, 25);//25 for k and k for anything less than 25
            k-=Math.min(k,25);
        }
        for(char c: ch)
        System.out.print(c);

       
    
    }

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int k=sc.nextInt();
            solve(n, k);
        }
        sc.close();
    }
}