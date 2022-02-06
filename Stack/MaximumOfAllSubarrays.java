import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumOfAllSubarrays {
    static int[] find(int arr[], int n, int k) {
        int ans[] = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();

        int i = 0;

        // preprocess first k..as we get answer after preprocessing
        for (; i < k; i++) {
            while (!q.isEmpty() && arr[q.peekLast()] <= arr[i])
                q.removeLast();
            q.addLast(i);
        }

        for (; i < n; i++) {
            ans[i - k] = arr[q.peekFirst()];

            // delete old elements
            while (!q.isEmpty() && q.peekFirst() <= i - k)
                q.removeFirst();

            // maintain property
            while (!q.isEmpty() && arr[q.peekLast()] <= arr[i])
                q.removeLast();

            q.addLast(i);
        }
        ans[i - k] = arr[q.peekFirst()];

        return ans;
    }

    public static void main(String[] args) {
        // int arr[] = { 12, 1, 78, 90, 57, 89, 56 };// 78 90 90 90 89
        // int arr[] = { 8, 4, 3, -6, 10 };
        int arr[] = { 8, 4, 3, -6, 10, 12, 15 };// 8 4 10 12 15
        int k = 3;
        int max[] = find(arr, arr.length, k);
        // printMax(arr, arr.length, k);
        for (int i : max)
            System.out.print(i + " ");
    }
}
