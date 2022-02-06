import java.util.PriorityQueue;

/**
 * kthLargestSubArray Input: a[] = {20, -5, -1} k = 3 Output: 14 Explanation:
 * All sum of contiguous subarrays are (20, 15, 14, -5, -6, -1) so the 3rd
 * largest sum is 14.
 * 
 * Input: a[] = {10, -10, 20, -40} k = 6 Output: -10 Explanation: The 6th
 * largest sum among sum of all contiguous subarrays is -10.
 */
public class kthLargestSubArray {

    // O(n^2logn) - O(n)
    static void solve(int arr[], int n, int k) {
        int pre[] = new int[n + 1];
        pre[0] = 0;
        for (int i = 0; i < n; i++)
            pre[i + 1] = pre[i] + arr[i];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (pq.size() < k)
                    pq.add(pre[j] - pre[i - 1]);
                else {
                    if (pq.peek() < (pre[j] - pre[i - 1])) {
                        pq.poll();
                        pq.add(pre[j] - pre[i - 1]);
                    }
                }
            }
        }
        System.out.println(pq.peek());
    }

    public static void main(String[] args) {
        // int arr[] = { 20, -5, -1 };
        // int k = 3;// 14

        int arr[] = { 10, -10, 20, -40 };
        int k = 6;// -10
        solve(arr, arr.length, k);

    }
}