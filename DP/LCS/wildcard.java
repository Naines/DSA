import java.util.Arrays;

public class wildcard {
    static int match(char s1[], char s2[], int n, int m, int memo[][]){
        if(n==0 && m>1) return 0;
        if(n==0 && m==0)return 1;
        if(memo[n][m]!=-1) return memo[n][m];
        if(s1[n-1]==s2[m-1]  || s2[m-1]=='?')
        return match(s1, s2, n-1, m-1,memo);
        else if(s2[m-1]=='*')
        return match(s1, s2, n-1, m,memo);
        
        return 0;
    }
    public static void main(String[] args) {
        String str="b";
        String str1="?*?";
        int memo[][]=new int[str.length()+1][str1.length()+1];
        for(int i[]:memo) Arrays.fill(i, -1);
        System.out.println(match(str.toCharArray(), str1.toCharArray(), str.length(), str1.length(), memo));
    }
}
