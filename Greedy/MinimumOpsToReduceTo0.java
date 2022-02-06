import java.util.HashMap;
import java.util.Map;

/**
 * MinimumOpsToReduceTo0
 */
public class MinimumOpsToReduceTo0 
{

    static int solve(int nums[], int x)
    {
        int target = -x;
        for (int num : nums)
            target += num;

        if (target == 0)
            return nums.length; // since all elements are positive, we have to take all of them

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; ++i) {

            sum += nums[i];
            if (map.containsKey(sum - target)) {
                res = Math.max(res, i - map.get(sum - target));
            }

            // no need to check containsKey since sum is unique
            map.put(sum, i);
        }

        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }
    public static void main(String[] args) {
        //int arr[]={5,6,7,8,9}, x = 4;  //-1
        //int arr[]={1,1,4,2,3}, x = 5;  //2
        int arr[]={3,2,20,1,1,3}, x = 10; //5
         //int arr[]={1,1}, x = 3; //5
        
         System.out.println(solve(arr, x));
        
    }
}