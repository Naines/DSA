public class rotate90 {
    static void rotate1(int arr[][], int n)// left
    {
        for (int i = 0; i < (n / 2); i++) {
            for (int j = i; j < n - i - 1; j++) {
                int t = arr[i][j];
                arr[i][j] = arr[j][n - 1 - i];
                arr[j][n - 1 - i] = arr[n - 1 - i][n - 1 - j];
                arr[n - 1 - i][n - 1 - j] = arr[n - j - 1][i];
                arr[n - j - 1][i] = t;

            }
        }
    }

    static void rotate2(int arr[][], int n)// left
    {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= n - 1; j++) {
                System.out.print(arr[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        System.out.println("here");
        // rotate1(arr, arr.length);

        print(arr);
        System.out.println("here");
        System.out.println();
        rotate2(arr, arr.length);
    }

    ///////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////
    static void print(int arr[][]) {
        int r = arr.length;
        int c = arr[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
