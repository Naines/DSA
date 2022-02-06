import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class palin {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        char chs[] = fs.next().toUpperCase().toCharArray();
        int hash[] = new int[26];
        for (char ch : chs) {
            hash[ch - 'A']++;
        }
        // System.out.println(Arrays.toString(hash));
        int odd = 0;
        int ind = -1;
        for (int i = 0; i < 26; i++) {
            if (hash[i] % 2 != 0) {
                odd++;
                ind = i;
            }

        }
        // System.out.println("odd = " + odd);
        if (odd <= 1) {
            int i = 0, j = chs.length - 1;
            char palin[] = new char[chs.length];
            for (int x = 0; x < 26; x++) {
                if (hash[x] == 0 || hash[x] % 2 != 0)
                    continue;
                while (hash[x] != 0) {
                    palin[i++] = (char) (x + 65);
                    palin[j--] = (char) (x + 65);
                    // System.out.println(Arrays.toString(palin));
                    hash[x] -= 2;
                }
            }
            // System.out.println("INDEX+ " + ind + " " + i + " " + j);
            if (ind >= 0)
                while (hash[ind] != 0) {
                    palin[i++] = (char) (ind + 65);
                    hash[ind]--;
                    // System.out.println(Arrays.toString(palin));
                    if (hash[ind] > 0) {
                        palin[j--] = (char) (ind + 65);
                        hash[ind]--;
                    }

                    // System.out.println(Arrays.toString(palin));
                }
            // fs.println(Arrays.toString(palin));

            StringBuilder sb = new StringBuilder();
            for (char c : palin)
                sb.append(c);
            fs.println(sb.toString());
        } else {
            fs.println("NO SOLUTION");
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