import java.io.PrintWriter;
import java.util.Scanner;

/**
 * weirdProblem
 */
public class weirdProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        long n = sc.nextLong();
        while (n != 1) {
            out.print(n + " ");
            n = n % 2 == 0 ? n / 2 : n * 3 + 1;
        }
        // if (n != 1)
        out.print(1);
        sc.close();
        out.close();
    }
}