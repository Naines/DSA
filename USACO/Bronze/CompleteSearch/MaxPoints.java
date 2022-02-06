import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MaxPoints {
    static String name = "xyz";

    public static void main(String[] args) throws Exception {
        @SuppressWarnings("all")
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(name + ".in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        // PrintWriter out = new PrintWriter(new FileWriter(name + ".out"));

        int n = Integer.parseInt(st.nextToken());
        int x[] = new int[n], y[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            x[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            y[i] = Integer.parseInt(st.nextToken());

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dx = x[i] - x[j];
                int dy = y[i] - y[j];
                max = Math.max(max, dx * dx + dy * dy);
            }
        }
        out.println(max);
        out.close();
    }
}
