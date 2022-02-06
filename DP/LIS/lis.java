import java.util.Arrays;

class lis {

    static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n];
        Arrays.fill(lis, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }
        }
        int ans = lis[0];
        for (int i : lis)
            ans = Math.max(i, ans);
        return ans;
    }

    static int lengthOfLIS_BS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int size = 0;
        for (int x : nums) {
            int c = upper(tails, 0, size, x);
            tails[c] = x;
            if (c == size)
                ++size;
        }
        return size;
    }

    static int upper(int arr[], int lb, int ub, int key) {
        while (lb < ub) {
            int m = lb + (ub - lb) / 2;
            if (arr[m] < key) {
                lb = m + 1;
            } else {
                ub = m;
            }
        }
        return lb;
    }

    static int lengthOfLIS_BS_inbuilt(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int size = 0;
        for (int x : nums) {
            int c = Arrays.binarySearch(tails, 0, size, x);
            if (c < 0)
                c = -(c + 1);
            tails[c] = x;
            if (c == size)
                ++size;
        }
        return size;
    }

    public static void main(String[] args) {
        int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS_BS(nums));
        System.out.println(lengthOfLIS_BS_inbuilt(nums));
    }

}