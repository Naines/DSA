import java.util.Scanner;
public class CriticalEqn 
{
    static int d;
    static void gcd(int a, int b)
    {
        if(a==0)
        {
            d = b;
            return;
        }
        
        else
        {
            gcd(b % a, a);
            return;
        }
        
    }
    public static void main(String[] args)throws Exception
    {
        try{
            Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int k = 0;
        while(t-->0)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int ans = sc.nextInt();
            gcd(a,b);
           
            if((ans%d)==0)
            {
                k++;
                System.out.println("Case "+k+": Yes");
            }
            else
            {
                k++;
                System.out.println("Case " + k + ": No");
            }
        }
        sc.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    
}
