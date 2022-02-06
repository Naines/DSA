import java.util.ArrayList;

public class bitonic {
    public int binarysearch(ArrayList<Integer> arr, int start, int end, int key) {

        while (start <= end) {

            int mid = (start + end) / 2;

            if (arr.get(mid) == key)
                return mid;
            else if (key < arr.get(mid))
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public int reversebinarysearch(ArrayList<Integer> arr, int start, int end, int key) {

        while (start <= end) {

            int mid = (start + end) / 2;

            if (arr.get(mid) == key)
                return mid;
            else if (key < arr.get(mid))
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;

    }

    public int peakElement(ArrayList<Integer> arr) {

        int n = arr.size();
        int low = 0, high = (n - 1);

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (mid > 0 && mid < (n - 1)) {

                if (arr.get(mid) > arr.get(mid - 1) && arr.get(mid) > arr.get(mid - 1))
                    return mid;
                else if (arr.get(mid - 1) > arr.get(mid)) {
                    high = mid - 1;
                } else if (arr.get(mid + 1) > arr.get(mid)) {
                    low = mid + 1;
                }
            } else if (mid == 0) {

                if (arr.get(0) > arr.get(1))
                    return 0;
                else
                    return 1;
            } else if (mid == n - 1) {

                if (arr.get(n - 1) > arr.get(n - 2))
                    return n - 1;
                else
                    return n - 2;
            }
        }

        return -1;

    }

    public int solve(ArrayList<Integer> arr, int key) {
        int peak = peakElement(arr);
        int a = binarysearch(arr, 0, peak, key);
        int b = reversebinarysearch(arr, peak + 1, arr.size() - 1, key);

        return (a == -1) ? b : a;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int arr[] = { 1, 2, 3, 4, 5, 3, 2, 1 };
        for (int i : arr)
            list.add(i);
        bitonic ob = new bitonic();
        System.out.println(ob.solve(list, 1));
    }
}
