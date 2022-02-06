import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MixingMilk {
    static String name = "mixmilk";

    public static void main(String[] args) throws Exception {
        @SuppressWarnings("all")
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(name + ".in"));
        StringTokenizer st;
        // PrintWriter out = new PrintWriter(System.out);
        PrintWriter out = new PrintWriter(new FileWriter(name + ".out"));

        Pair pairs[] = new Pair[3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int t = 0;
        while (t < 100) {
            for (int i = 0; i < 3 && t < 100; i++) {
                int j = (i + 1) % 3;
                if (overflow(i, j, pairs)) {
                    pairs[i].m -= pairs[j].c - pairs[j].m;
                    pairs[j].m = pairs[j].c;
                } else {
                    pairs[j].m += pairs[i].m;
                    pairs[i].m = 0;
                }
                t++;
                // out.println("Iteration : " + t);
                // out.println(pairs[i]);
                // out.println(pairs[j]);
            }
        }
        for (Pair p : pairs)
            out.println(p);
        out.close();
    }

    static boolean overflow(int a, int b, Pair pairs[]) {
        if (pairs[a].m + pairs[b].m > pairs[b].c)
            return true;
        return false;
    }

    static class Pair {
        int m, c;

        Pair(int c, int m) {
            this.m = m;
            this.c = c;
        }

        public String toString() {
            return this.m + "";
            // return this.m + " " + this.c;
        }
    }
}
