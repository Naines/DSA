import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class largest_divisible_subset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;
        int lis[] = new int[n];
        int pre[] = new int[n];

        Arrays.fill(lis, 1);
        Arrays.fill(pre, -1);
        int max = -1, index = 0;
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                    if (lis[i] <= lis[j]) {
                        lis[i] = lis[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (max < lis[i]) {
                max = lis[i];
                index = i;
            }
        }
        for (int i : lis) {
            System.out.print(i + " ");
        }
        System.out.println();
        while (index != -1) {
            list.add(nums[index]);
            index = pre[index];
        }
        return list;
    }

    public static void main(String[] args) {
        int nums[] = { 5, 9, 18, 54, 108, 540, 90, 180, 360, 720 };
        System.out.println(largestDivisibleSubset(nums));
    }
}
