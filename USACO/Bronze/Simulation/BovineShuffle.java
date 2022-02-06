import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BovineShuffle {
    public static void main(String[] args) throws Exception {
        Reader sc = new Reader("shuffle");
        PrintWriter out = new PrintWriter(new FileWriter("shuffle.out"));
        // Reader sc = new Reader();
        int n = sc.nextInt();
        int next[] = sc.readArray(n);
        int id[] = sc.readArray(n);

        char chs[] = new char[n];
        for (int i = 0; i < n; i++) {
            chs[i] = (char) ('a' + i);
        }
        for (int i = 1; i <= 3; i++) {
            char t[] = new char[n];
            for (int j = 0; j < n; j++) {
                int x = next[j] - 1;
                t[x] = chs[j];
            }
            chs = t;
        }

        Pair pairs[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(chs[i], id[i]);
        }
        Arrays.sort(pairs);
        for (Pair p : pairs)
            out.println(p.key);
        out.close();
    }

    static class Pair implements Comparable<Pair> {
        int key;
        char num;

        Pair(char x, int y) {
            this.num = x;
            this.key = y;
        }

        public int compareTo(Pair o) {
            return this.num - o.num;
        }
    }

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Reader(String name) {
            try {
                br = new BufferedReader(new FileReader(name + ".in"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                return st.nextToken();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (Exception e) {
                e.printStackTrace();

            }
            return str;
        }

        int[] readArray(int n) {
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }
    }
}
