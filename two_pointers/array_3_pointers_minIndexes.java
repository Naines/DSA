public class array_3_pointers_minIndexes {
    static void solve(int a[], int b[], int c[]) {
        int ansi = -1, ansj = -1, ansk = -1;
        int n = a.length, m = b.length, o = c.length;
        int i = 0, j = 0, k = 0;
        int diff = (int) 1e9;
        while (i < n && j < m && k < o) {
            int min = Math.min(a[i], Math.min(b[j], c[k]));
            int max = Math.max(a[i], Math.max(b[j], c[k]));

            if (max - min < diff) {
                diff = max - min;
                ansi = i;
                ansj = j;
                ansk = k;
            }

            if (diff == 0)
                break;

            if (a[i] == min)
                i++;
            else if (b[j] == min)
                j++;
            else
                k++;
        }
        System.out.println(ansi + " " + ansj + " " + ansk);
    }

    public static void main(String[] args) {
        int A[] = { 1, 4, 10 };
        int B[] = { 2, 15, 20 };
        int C[] = { 10, 12 };

        // Function calling
        solve(A, B, C);
    }
}
