import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class io1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int a = Integer.parseInt(br.readLine());

        out.println(a);
        out.close();
    }
}
