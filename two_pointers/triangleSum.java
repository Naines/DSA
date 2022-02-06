import java.util.Arrays;

public class triangleSum {
    static int tri(int arr[], int n) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = n - 1; i >= 1; i--) {
            int low = 0, high = i - 1;
            while (low < high) {
                if (arr[low] + arr[high] > arr[i]) {
                    count += (high - low);
                    high--;
                    // count += (high - low);
                } else {
                    low++;
                }
            }
        }
        return count;
    }

    static int tri2(int A[], int n) {
        Arrays.sort(A);
        int count = 0;
        for (int i = n - 1; i >= 1; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (A[l] + A[r] > A[i]) {
                    count += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 1, 1 };
        int arr[] = { 1, 1, 1, 2, 2 };
        System.out.println(tri(arr, arr.length));
        System.out.println(tri2(arr, arr.length));
    }
}
