import java.util.Arrays;

public class lds {
    static int lengthOfLDS(int nums[]) {
        int n = nums.length;
        int lds[] = new int[n];
        Arrays.fill(lds, 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j <= n - 1; j++) {
                if (nums[j] < nums[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }
        int max = lds[0];
        for (int i : lds) {
            System.out.print(i + " ");
            max = Integer.max(max, i);
        }
        System.out.println();
        return max;
    }

    public static void main(String[] args) {
        int nums[] = { 15, 27, 14, 38, 63, 55, 46, 65, 85 };

        System.out.println(lengthOfLDS(nums));

    }
}
