

import java.util.ArrayList;

public class subsets 
{   static void backtrack(int nums[], int index, ArrayList<Integer> temp)
    {
        System.out.print(temp+" ");
        for(int i=index;i<nums.length;i++)
        {
            temp.add(nums[i]);
            backtrack(nums, i+1, temp);
            temp.remove(temp.size()-1); //backtrack
        }
       
    }
 
    public static void main(String[] args) 
    {
        int nums[]={1,2,3};
       backtrack(nums, 0 ,new ArrayList<Integer>());     
    }
}
