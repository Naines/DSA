import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MilkPails {
    static String name = "pails";

    public static void main(String[] args) throws Exception {
        @SuppressWarnings("all")
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(name + ".in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // PrintWriter out = new PrintWriter(System.out);
        PrintWriter out = new PrintWriter(new FileWriter(name + ".out"));

        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken()),
                target = Integer.parseInt(st.nextToken());
        int x = (target + n - 1) / m, y = (target + n - 1) / n;
        int max = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int fill = m * i + n * j;
                if (fill <= target)
                    max = Math.max(max, fill);
            }
        }
        out.println(max);
        out.close();
    }
}
