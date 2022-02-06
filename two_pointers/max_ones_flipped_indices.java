import java.util.Arrays;

public class max_ones_flipped_indices {
    static void solve(int arr[], int k) {
        int n = arr.length;
        int cnt0 = 0;
        int l = 0;
        int max_len = 0, ansi = -1, ansj = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                cnt0++;

            while (cnt0 > k) {
                if (arr[l] == 0)
                    cnt0--;
                l++;
            }
            if (i - l + 1 > max_len) {
                ansi = l;
                ansj = i;
                max_len = i - l + 1;
            }
        }
        int ans[] = new int[max_len];
        for (int p = ansi; p <= ansj; p++)
            ans[p - ansi] = p;
        System.out.println(Arrays.toString(ans));
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 1, 1, 1, 0, 1, 0, 0 };
        int b = 2;
        solve(arr, b);
    }
}
