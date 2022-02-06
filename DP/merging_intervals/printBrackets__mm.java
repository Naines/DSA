public class printBrackets__mm {
    static char name;

    static String print(int i, int j, int brackets[][], String str) {
        if (i + 1 == j) {
            str += name;
            name++;
            return str;
        }
        str += '(';
        str = print(i, brackets[i][j], brackets, str);
        str = print(brackets[i][j], j, brackets, str);
        str += ')';
        return str;
    }

    static int mm2(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        int brackets[][] = new int[n][n];

        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int x = dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j];
                    if (dp[i][j] > x) {
                        dp[i][j] = x;
                        brackets[i][j] = k;
                    }
                }
            }
        }

        name = 'A';

        System.out.println(print(0, n - 1, brackets, ""));
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 3, 4 };
        System.out.println(mm2(arr));
    }
}
