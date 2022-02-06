import java.util.Scanner;

public class longestPalindrome 
{

    //made by simple brute force will give TLE 
    //solutions can be remebered. Hence optimize to dp.
    static void findlongestpalinSubstring(String str)
    {
        int n=str.length();
        String palin="";
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                String sub=str.substring(i, j+1);
                if(isPalin(sub) && sub.length()> palin.length())
                palin=sub;
            }
        }
        System.out.println(palin);
    }
    static boolean isPalin(String str)
    {
        char ch[]=str.toCharArray();
        int i=0,j=str.length()-1;
        while(i<=j)
        {
            if(ch[i]==ch[j])
            {
                i++;
                j--;
            }
            else
            return false;
        }
        return true;
    }

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        findlongestpalinSubstring(str);
        sc.close();
    }
}
