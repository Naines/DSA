import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IncreasingArray {
    static void solve(int arr[], int n) {
        int x = arr[0];
        long ans = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < x) {
                int add = x - arr[i];
                arr[i] += add;
                ans += add;
            }
            x = arr[i];
        }
        fs.println(ans);
    }

    public static void main(String[] args) throws Exception {
        // FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int arr[] = fs.readArray(n);
        solve(arr, n);

        fs.close();
    }

    //////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////

    static FastScanner fs;
    static {
        fs = new FastScanner();
        // try {
        // fs = new FastScanner("problemname");
        // } catch (IOException e) {
        // }
    }

    static class FastScanner extends PrintWriter {
        BufferedReader br;
        StringTokenizer st;

        // standard input
        FastScanner() {
            this(System.in, System.out);
        }

        public FastScanner(InputStream i, OutputStream o) {
            super(o);
            br = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        FastScanner(String problemName) throws IOException {
            super(new FileWriter(problemName + ".out"));
            br = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        String nextLine() throws Exception {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                throw new Exception(e.toString());
            }
            return str;
        }
    }
}