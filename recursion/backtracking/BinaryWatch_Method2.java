import java.util.ArrayList;
import java.util.List;

/**
 * BinaryWatch_Method2
 */
public class BinaryWatch_Method2 {
    static List<String> readBinaryWatch(int n)
    {
        List<String> res=new ArrayList<>();
        int nums1[]={8,4,2,1};
        int nums2[]={32, 16, 8, 4,2,1};
        for(int i=0;i<=n;i++)
        {
            List<Integer> l1= generate(nums1, i);
            List<Integer> l2=generate(nums2, n-i);
            
            for(int num1: l1)
            {
                if(num1>=12) continue;
                for(int num2: l2)
                {
                    if(num2 >=60)   continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                    //res.add(String.format("%d:%02d",num1,num2));
                }
            }
            
        }
        return res;
    }
    private static List<Integer> generate(int nums[], int n)
    {
        List<Integer> list=new ArrayList<>();
        generator(list, nums, n,0, 0);
        return list;
    }
    private static void generator(List<Integer> list, int nums[], int count, int sum, int pos)
    {
        if(count==0)
        {
            list.add(sum);
            return;
        }

        for(int i=pos;i<nums.length;i++)
        {
            //sum+=nums[i];
            generator(list, nums, count-1, sum+nums[i], pos+1);
           // sum-=nums[i];
        }
    }

    public static void main(String[] args) {
        int num=9;
        System.out.println(readBinaryWatch(num));
    }
}