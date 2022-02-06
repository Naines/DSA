import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NumberSpiral {
    static void solve() {
        int a = fs.nextInt(), b = fs.nextInt();
        if (a > b) {
            if (a % 2 == 0)
                fs.println((long) a * (long) a - (long) b + 1);
            else
                fs.println((long) (a - 1) * (long) (a - 1) + (long) b);
        } else {
            if (b % 2 == 0)
                fs.println((long) (b - 1) * (b - 1) + a);
            else
                fs.println((long) b * b - a + 1);
        }
    }

    static FastScanner fs;

    public static void main(String[] args) throws Exception {
        fs = new FastScanner();
        int t = fs.nextInt();
        for (int tt = 0; tt < t; tt++) {
            solve();
        }
        fs.close();
    }

    //////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////

    // static FastScanner fs;
    // static {
    // // fs = new FastScanner();
    // try {
    // fs = new FastScanner("problemname");
    // } catch (IOException e) {
    // }
    // }

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