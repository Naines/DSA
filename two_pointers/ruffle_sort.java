import java.util.Arrays;
import java.util.Random;

public class ruffle_sort {
    public static void main(String[] args) {
        int arr[] = { 232, 43, 33, 42234, 2, 34, 1, 42, 2, 31, 32, 12, 132, 132 };
        sort(arr, arr.length);
        for (int i : arr)
            System.out.print(i + " ");
    }

    static void sort(int arr[], int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int x = rand.nextInt(n);
            int temp = arr[x];
            arr[x] = arr[i];
            arr[i] = temp;
        }
        Arrays.sort(arr);
    }
}
