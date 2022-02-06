public class max_ones_replacing_zeroes {

    static void solve1(int a[], int k) {
        int n = a.length;
        int cnt0 = 0;
        int l = 0;
        int max_len = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0)
                cnt0++;

            while (cnt0 > k) {
                if (a[l] == 0)
                    cnt0--;
                l++;
            }

            max_len = Math.max(max_len, i - l + 1);
        }

        System.out.println(max_len);
    }

    public static void main(String[] args) {
        // int A[] = { 1, 0, 0, 1, 1, 0, 1 }, B = 1;
        // int A[] = { 1, 0, 0, 1, 0, 1, 0, 1, 0, 1 }, B = 2;
        int A[] = { 0, 1, 0, 1, 0, 0 }, B = 4;
        solve1(A, B);
    }
}
