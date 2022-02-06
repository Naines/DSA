import java.util.Arrays;

public class max_length_of_pair_chain {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Pair arr[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(pairs[i][0], pairs[i][1]);
        }
        Arrays.sort(arr);
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j].second < arr[i].first) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = dp[0];
        for (int i : dp)
            max = Math.max(i, max);
        return max;
    }

    static class Pair implements Comparable<Pair> {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int compareTo(Pair o) {
            return this.first - o.first;
        }
    }
}
