import java.util.HashMap;
import java.util.Map;

public class number_subarray_exactlykDistinct {
    static int atmostK(int arr[], int k) {
        int left = 0, right = 0, n = arr.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < n) {

            // expand window
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            // if window size exceed k
            while (map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == -1)
                    map.remove(arr[left]);
                left++;
            }

            count += right - left + 1;
            right++;
        }
        return count;
    }
}
