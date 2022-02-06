import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class fun2 {
    static boolean submit = false;
    static String filename = "rectangle/asdf";
    static FastScanner fs;

    static void solve() {
        int a = fs.nextInt();
        boolean prime[] = new boolean[a + 1];
        for (int i = 2; i * i <= a; i++) {
            if (prime[i] == false)
                for (int j = i * i; j <= a; j += i) {
                    prime[j] = true;
                }
        }
        int k = 1;
        for (int i = 2; i <= a; i++) {
            if (prime[i] == false)
                fs.print(i + " ");
            if (k % 1000 == 0) {
                fs.println();
                k = 1;
            }
            k++;
        }
        fs.close();
    }

    public static void main(String[] args) throws IOException {
        if (submit) {
            fs = new FastScanner(filename);
        } else {
            fs = new FastScanner();
        }
    }

    // static class Reader {

    // Reader() {
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st = new StringTokenizer("");
    // }

    // String next() {
    // while (!st.hasMoreTokens())
    // try {
    // st = new StringTokenizer(br.readLine());
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // return st.nextToken();
    // }

    // int nextInt() {
    // return Integer.parseInt(next());
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
            return st.nextToken();
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
