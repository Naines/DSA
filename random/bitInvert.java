import java.util.Scanner;

public class bitInvert {
    static int invert(int n) {
        StringBuffer sb = new StringBuffer();
        if (n == 0)
            return 1;
        while (n > 0) {
            int d = n % 2;
            d = d ^ 0 ^ 1;
            n = n / 2;
            sb.append(d);
        }
        char ch[] = sb.toString().toCharArray();
        int ans = 0;
        int mul = 1;
        for (char c : ch) {
            ans = ans + mul * (c - '0');
            mul = mul * 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            System.out.println(invert(n));
        }
    }
}
