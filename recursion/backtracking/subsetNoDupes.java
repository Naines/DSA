

import java.util.ArrayList;
import java.util.HashSet;

/**
 * subsetNoDupes
 */
public class subsetNoDupes 
{
   
    static void backtrack(int nums[], int idx, ArrayList<Integer> temp)
    {
        System.out.println(temp);
        for(int i=idx;i<nums.length;i++)
        {
            if (i > idx && nums[i] == nums[i - 1])
                continue;
            temp.add(nums[i]);
            backtrack(nums, i+1, temp);
            temp.remove(temp.size() - 1);
            
        }
    }
    static void backtrack1(int nums[], int index, ArrayList<Integer> temp)
    {
        System.out.println(temp);
        HashSet<Integer> hs=new HashSet<>();
        for(int i=index;i<nums.length;i++)
        {
            if(hs.contains(nums[i])) continue;
            hs.add(nums[i]);
            temp.add(nums[i]);
            backtrack1(nums, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args) {
        int nums[]={1,2,3,2};
        //Arrays.sort(nums);
        //backtrack(nums, 0, new ArrayList<>());
        //System.out.println("-----------------");
        backtrack1(nums, 0, new ArrayList<>());
    }
}