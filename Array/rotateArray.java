public class rotateArray {
    // right rotation/ clockwise rotate by k units
    static void rotate(int arr[], int n, int k) {
        int temp[] = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[n - i - 1];
        }
        for (int i = n - k - 1; i >= 0; i--) {
            arr[(i + k) % n] = arr[i];
        }
        for (int i = 0; i < k; i++) {
            arr[i] = temp[k - i - 1];
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        int k = 5;
        rotate(arr, arr.length, k);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
