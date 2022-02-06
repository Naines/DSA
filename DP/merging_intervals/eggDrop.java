import java.util.Arrays;

/**
 * eggDrop
 */
public class eggDrop {

    static int minTrials(int f, int e) {
        if (f == 1 || f == 0)
            return f;
        if (e == 1)
            return f;
        int res = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            res = Math.max(minTrials(k - 1, e - 1), minTrials(f - k, e));
            min = Math.min(min, res);
        }
        return min + 1;
    }
    static int minTrials1(int f, int e, int memo[][]) {
        if (f == 1 || f == 0)
            return memo[f][e]=f;
        if (e == 1)
            return memo[f][e]=f;
        if(memo[f][e]!=-1) return memo[f][e];
        int res = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            res = Math.max(minTrials1(k - 1, e - 1,memo), minTrials1(f - k, e,memo));
            min = Math.min(min, res);
        }
        return memo[f][e]=min + 1;
    }
    static int minTrials3(int f, int e){
        int dp[][]=new int[f+1][e+1];
        for(int i=1;i<=e;i++){
            dp[1][i]=1;
        }
        for(int i=2;i<=f;i++){
            dp[i][1]=i;
        }
        for(int i=2;i<=f;i++){
            for(int j=2;j<=e;j++){
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=1;k<=i;k++){
                    int res=Math.max(dp[i-1][j-1], dp[i-k][j]);
                    dp[i][j]=Math.min(dp[i][j], res);
                }
            }
        }
        disp(dp);
        return dp[f][e]+1;
    }

    

    public static void main(String[] args) {
        // int f = 2, e = 2;//2
        int f = 4, e = 2;//3
        // int f = 10, e = 2;//3
        System.out.println(minTrials(f, e));

        int memo[][]=new int[f+1][e+1];
        for(int i[]:memo)Arrays.fill(i, -1);
        System.out.println( minTrials1(f, e, memo));


        System.out.println(minTrials3(f, e));
        
    }
    static void disp(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}