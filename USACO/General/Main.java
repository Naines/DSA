import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader r;
    static PrintWriter pw;
    static {
        try {
            r = new BufferedReader(new FileReader("problemname.in"));
            pw = new PrintWriter(new FileWriter("problemname.out"));
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        pw.print("sum is ");
        pw.println(a + b + c);
        pw.close(); // make sure to include this line -- closes io and flushes the output
    }
}
