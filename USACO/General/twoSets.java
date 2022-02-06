import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class twoSets {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        long sum = n * (n + 1) / 2;
        if (sum % 2 != 0) {
            fs.println("NO");
        } else {
            fs.println("YES");
            ArrayList<Integer> l1 = new ArrayList<>();
            ArrayList<Integer> l2 = new ArrayList<>();

            int j = n % 4 == 0 ? 4 : 3;
            for (int i = 0; i < (n - 1) / 4; i++) {
                l1.add(4 * i + j + 1);
                l1.add(4 * i + j + 4);
                l2.add(4 * i + j + 2);
                l2.add(4 * i + j + 3);
            }

            if (n % 4 != 0) {
                l1.add(1);
                l1.add(2);
                l2.add(3);
            } else {
                l1.add(1);
                l1.add(4);
                l2.add(2);
                l2.add(3);
            }

            fs.println(l1.size());
            for (int i : l1)
                fs.print(i + " ");
            fs.println();
            fs.println(l2.size());
            for (int i : l2)
                fs.print(i + " ");

        }

        fs.close();

    }

    //////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////

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