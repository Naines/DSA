public class maximalString {
    public String solve(String A, int B) {
        max = A;
        char chs[] = A.toCharArray();
        int n = chs.length;
        solve(chs, n, B);
        return max;
    }

    String max = "";

    void solve(char chs[], int n, int k) {
        if (k == 0)
            return;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (chs[i] < chs[j]) {
                    // int temp = Integer.parseInt(String.valueOf(chs));
                    swap(chs, i, j);
                    if (max.compareTo(String.valueOf(chs)) < 0)
                        max = String.valueOf(chs);
                    solve(chs, n, k - 1);
                    swap(chs, i, j);
                }
            }
        }
        // return String.valueOf(chs);
    }

    void swap(char chs[], int a, int b) {
        char temp = chs[a];
        chs[a] = chs[b];
        chs[b] = temp;
    }

    public static void main(String[] args) {
        maximalString ob = new maximalString();
        System.out.println(ob.solve("3232", 1));
    }
}
