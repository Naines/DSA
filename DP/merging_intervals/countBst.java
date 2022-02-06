import java.util.Arrays;

class countBst {
    static int count1(int n){
        if(n==0||n==1)return 1;
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=(count1(i)*count1(n-i-1));
        }
        return ans;
    }
    static int memo[];
    static int count3(int n){
        if(n==0||n==1)return memo[n]=1;
        if(memo[n]!=-1)return memo[n];
        int ans=0;
        for(int i=0;i<n;i++){
             ans+=(count3(i)*count3(n-i-1));
        }
        return memo[n]=ans;
    }
    static int count(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println(count(n));

        // m2-catalan number -dont work unless mod allowed
        System.out.println(nCk(2 * n, n) / (n + 1));


        System.out.println(count1(n));

        memo=new int[n+1];
        Arrays.fill(memo, -1);
        System.out.println(count3(n));
    }

    static int fact(int n) {
        int fact[] = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++)
            fact[i] = i * fact[i - 1];
        return fact[n];
    }

    static long nCk(int n, int k) {
        if (k > n)
            throw null;
        return fact(n) / (fact(k) * fact(n - k));
    }
}