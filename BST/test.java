public class test {
    static int bs(int arr[]) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            // System.out.println("low = " + low + " high = " + high);
            int mid = low + (high - low) / 2;
            if ((mid == 0 || arr[mid - 1] < arr[mid]) && (mid == arr.length - 1 || arr[mid + 1] < arr[mid]))
                return mid;
            else if ((mid == 0 || arr[mid - 1] < arr[mid]) && (mid == arr.length - 1 || arr[mid + 1] > arr[mid])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 5, 7, 4 };
        System.out.println(bs(arr));
    }
}
