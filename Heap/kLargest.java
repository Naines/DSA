import java.util.PriorityQueue;

public class kLargest {
    int[] solve(int[] arr, int n, int k) {
        // code here
        int ans[] = new int[k];
        int i = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (; i < k; i++)
            pq.add(arr[i]);
        while (i < n) {
            if (pq.peek() < arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
            i++;
        }
        for (i = k - 1; i >= 0; i--)
            ans[i] = pq.poll();
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1213, 34, 324, 324, 3, 4, 32, 312, 25, 356, 56, 64, 46, 667 };
        int ans[] = new kLargest().solve(arr, arr.length, 2);
        for (int i : ans)
            System.out.print(i + " ");
    }
}
