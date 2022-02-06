import java.util.Arrays;

public class max_length_of_pair_chain_greedy {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Pair arr[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(pairs[i][0], pairs[i][1]);
        }
        Arrays.sort(arr);
        int curr = Integer.MIN_VALUE;
        int ans = 0;
        for (Pair p : arr) {
            if (curr < p.first) {
                ans++;
                curr = p.second;
            }
        }
        return ans;
    }

    static class Pair implements Comparable<Pair> {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int compareTo(Pair o) {
            return this.second - o.second;
        }
    }

}
