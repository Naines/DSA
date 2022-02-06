import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SpeedingTicket {
    static String name = "speeding";

    public static void main(String[] args) throws Exception {
        @SuppressWarnings("all")
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(name + ".in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // PrintWriter out = new PrintWriter(System.out);
        PrintWriter out = new PrintWriter(new FileWriter(name + ".out"));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int seg[] = new int[101];
        int start = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int ii = 1; ii <= a; ii++)
                seg[ii + start] = b;

            start += a;
        }
        start = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int ii = 1; ii <= a; ii++)
                seg[ii + start] = b - seg[ii + start];

            start += a;
        }

        int max = 0;
        for (int i = 0; i < seg.length; i++) {
            max = Math.max(max, seg[i]);
        }
        // out.println(Arrays.toString(seg));
        out.println(max);
        out.close();
    }
}
