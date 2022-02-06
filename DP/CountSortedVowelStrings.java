import java.util.Arrays;
import java.util.Scanner;

/**
 * CountSortedVowelStrings
 */
public class CountSortedVowelStrings 
{
    static int countVowels(int n)
    {
        int dp[][]=new int[n+1][5];
        Arrays.fill(dp[0],1);
        for(int i=1;i<=n;i++)
        {
            for(int j=4;j>=0;j--)
            {
                if(j==4)
                dp[i][j]=dp[i-1][j];
                else
                dp[i][j]=dp[i][j+1]+dp[i-1][j];
            }
        }
        return dp[n][0];
    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println( countVowels(n));
        sc.close();
       
    }
}