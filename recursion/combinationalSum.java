import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationalSum {

    // https://leetcode.com/problems/combination-sum/
    static void backtrack(int nums[], List<Integer> temp, int trgt, int index)
    {
        if(trgt<0)  return;
        if(trgt==0){
            System.out.println(temp);
            return;
        }
        System.out.println(index+" "+trgt);
        for(int i=index;i<nums.length;i++)
        {
            temp.add(nums[i]);
            backtrack(nums, temp, trgt-nums[i], i);
            temp.remove(temp.size()-1);
        }
    }


    static void backtrack1(int nums[], List<Integer> temp, int target, int index, boolean vis[])
    {
        if(target<0)
        return;
        if(target==0)
        {
            System.out.println(temp);
            return;
        }
        for(int i=index;i<nums.length;i++)
        {
            if(nums[i]>target)  continue;
            if(vis[i])continue;
            vis[i]=true;
            temp.add(nums[i]);
            backtrack1(nums, temp, target-nums[i], i+1, vis);
            vis[i]=false;
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args) {
        int nums[]={1,3};
        //backtrack(nums, new ArrayList<>(), 4, 0);

       nums=new int[]{ 10, 1, 2, 7, 6, 1, 5};
        Arrays.sort(nums);
        backtrack1(nums, new ArrayList<>(), 12, 0,new boolean[nums.length]);
    }
}
