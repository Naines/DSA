import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class fun {
    static boolean submit = false;
    static String filename = "rectangle/asdf";

    static void solve(Scanner sc, PrintWriter out) {
        int a = sc.nextInt();
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
                out.print(i + " ");
            if (k % 1000 == 0) {
                out.println();
                k = 1;
            }
            k++;
        }
        out.close();
    }

    public static void main(String[] args) throws IOException {
        if (submit) {
            solve(new Scanner(System.in), new PrintWriter(System.out));
        } else {
            solve(new Scanner(new File(filename + ".in")), new PrintWriter(new File(filename + ".out")));
        }
    }
}
