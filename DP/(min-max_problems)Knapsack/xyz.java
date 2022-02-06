// class Solution {

//     // public int jump(int[] nums) {
//     // // int[] dp=new int[nums.length];
//     // // Arrays.fill(dp,-1);
//     // // return rec(nums,0,dp);
//     // return BU(nums);
//     // }

//     // public int rec(int[] nums, int j, int[] dp) {
//     // if (j >= nums.length - 1)
//     // return 0;
//     // if (dp[j] != -1)
//     // return dp[j];

//     // int minJ = 1000000;
//     // for (int i = 1; i <= nums[j]; i++) {

//     // minJ = Math.min(minJ, rec(nums, j + i, dp) + 1);

//     // }
//     // dp[j] = minJ;
//     // return minJ;

//     // }

//     public int BU(int[] nums) {
//         int dp[] = new int[nums.length];
//         dp[nums.length - 1] = 0;

//         for (int j = nums.length - 2; j >= 0; j--) {
//             int minJ = 1000000;
//             for (int i = 1; i <= nums[j]; i++) {

//                 if (j + i >= nums.length)
//                     break;
//                 minJ = Math.min(minJ, dp[j + i] + 1);

//             }
//             dp[j] = minJ;

//         }
//         return dp[0];
//     }

// }
class Solution {

    public int findMax(int i, int j, int[] nums) {
        int minDist = 10001;
        int index = 0;
        int len = nums.length - 1;
        while (i <= j) {
            if (len - i - nums[i] <= minDist) {
                minDist = len - i - nums[i];
                index = i;
            }
            i++;
        }
        return index;
    }

    public int jump(int[] nums) {
        int jumps = 0;
        int start = 0;
        int last = nums.length - 1;

        while (start < last) {
            jumps++;

            if (start + nums[start] < last) {
                start = findMax(start + 1, start + nums[start], nums);
            } else {
                break;
            }
        }

        return jumps;
    }
}
