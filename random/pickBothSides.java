import java.util.Scanner;

public class pickBothSides {
    public static int solve(int[] A, int B) {
        int sum = 0, n = A.length;
        for (int i = 0; i < B; i++)
            sum += A[i];
        int sum1 = sum;
        for (int i = 0; i < B; i++) {
            sum1 = sum1 + A[n - i - 1] - A[B - i - 1];
            sum = Math.max(sum1, sum);
        }
        return sum;

    }

    static int solve1(int A[], int B) {
        int len = A.length;
        if (B > len)
            return -1;
        int s = 0, min = 0, i, x;
        int n = len - B;
        for (i = 0; i < len; i++) {
            s += A[i];
            if (i < n)
                min += A[i];
        }

        if (B == len)
            return s;
        x = min;

        for (i = 0; i < B; i++) {
            x = x + A[i + n] - A[i];
            if (min > x)
                min = x;
        }
        return s - min;

    }

    /**
     * A : [ -533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173,
     * 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284,
     * 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322,
     * -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141,
     * -277, 741, 529, -222, -684, 35 ]
     * B : 48
     * 
     * A = [1,2,3,67,56,78]
     * B=3
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int b = sc.nextInt();
        // solve(arr, b);
        System.out.println(solve(arr, b));
        System.out.println(solve1(arr, b));
        sc.close();
    }
}
