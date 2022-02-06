import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BookAllotment {
    public static boolean isValid(int arr[], int mid, int n, int m) {
        int stu = 1, pages = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] + pages > mid) {
                stu++;
                pages = arr[i];
                if (stu > m)
                    return false;
            } else {
                pages += arr[i];
            }
        }
        return true;
    }

    public static int findPages(int[] arr, int n, int m) {
        if (n < m)
            return -1;

        int totpages = 0;
        int ub = 0, lb = 0;
        for (int i = 0; i < n; i++) {
            totpages += arr[i];
            lb = Math.max(lb, arr[i]);
        }
        int ans = -1;
        ub = totpages;
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (isValid(arr, mid, n, m)) {
                ans = mid;
                ub = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // FastScanner fs=new FastScanner();
        // int n=fs.nextInt();
        // int arr[]=fs.readArray(n);
        // int m=fs.nextInt();
        // int arr[]={73, 58, 30, 72, 44, 78, 23, 9 };
        int arr[] = { 73, 58, 30, 72, 44, 78, 23, 9 };
        Arrays.sort(arr);
        int m = 5, n = arr.length;
        System.out.println(findPages(arr, n, m));

    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
