public class partition_equal_sum_subset {
    static int count(int n, int arr[], int sum) {
        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;
        if (arr[n - 1] <= sum)
            return count(n - 1, arr, sum - arr[n - 1]) + count(n - 1, arr, sum);
        else
            return count(n - 1, arr, sum);
    }

    public static void main(String[] args) {
        int arr[] = { 478, 757, 314, 471, 729, 100, 459, 618 };
        int n = arr.length;
        int sum = 0;
        for (int i : arr)
            sum += i;
        if (sum % 2 != 0)
            System.out.println("NO");
        else
            System.out.println(count(n, arr, sum / 2));
    }
}
