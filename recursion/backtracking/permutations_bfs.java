

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class permutations_bfs
{

    //assumption no distinct numbers present in array
    //bfs solution
    static void perm(int nums[], List<Integer> temp)
    {
        if(temp.size()==nums.length)
        {
            System.out.println(temp);
            return;
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(temp.contains(nums[i])) continue;   //pruning
            temp.add(nums[i]);
            perm(nums, temp);
            temp.remove(temp.size()-1);
        }
    }
    
    //No assumptions taken
    //bfs solution
    static void perm1(int nums[], List<Integer> temp,boolean vis[]) 
    {
        if (temp.size() == nums.length) {
            System.out.println(temp);
            return;
        }
        for (int i = 0; i < nums.length; i++) 
        {
            if(vis[i])  continue;   //pruning
            vis[i]=true;
            temp.add(nums[i]);
            perm1(nums, temp, vis);
            temp.remove(temp.size() - 1);
            vis[i]=false;
            
        }
    }

    //bfs 
    //no perm dupes
    //requires arr[] to be sorted in non-decreasing order
    static void permNoDupes(int nums[],List<Integer> temp, boolean vis[])
    {
        if (temp.size() == nums.length) {
            System.out.println(temp);
            return;
        }
        
        for (int i = 0; i < nums.length; i++) 
        {
            if (vis[i] || i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])
                continue;
            vis[i] = true;
            temp.add(nums[i]);
            permNoDupes(nums, temp, vis);
            temp.remove(temp.size() - 1);
            vis[i] = false;
        }
    }
    public static void main(String[] args) 
    {
        int nums[]={1,2,2};
        System.out.println("dupes allowed");
        System.out.println("sol 1 :(no distinct dig allowed)");
        perm(new int[]{1,2,3}, new ArrayList<Integer>());

        System.out.println("sol 2 :");
        perm1(nums, new ArrayList<Integer>(), new boolean[nums.length]);

        System.out.println("no dupes");
        System.out.println("sol 1 :");
        Arrays.sort(nums);
        permNoDupes(nums, new ArrayList<>(), new boolean[nums.length]);
        
    }
}