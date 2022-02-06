import java.util.Arrays;
import java.util.Random;

/**
 * MinimumHeightDiff
 */
public class MinimumHeightDiff 
{
    //arr[i]<arr[x] ==> arr[i]+k<arr[x]+x
    //hence only update ans if arr[i]-k is possible
    //else ans doesnt change
    static void solve2(int arr[], int n, int k)
    {
        Arrays.sort(arr);

        //possible ans as arr[i]<arr[x] ==> arr[i]+k<arr[x]+x
        int ans = arr[n - 1] - arr[0];
        int smallest = arr[0] + k, 
            largest = arr[n - 1] - k;
        for (int i = 0; i < n - 1; i++) 
        {
            //find minm tower height from 1..N AND find maximum from 0..n-1
            //so that smallest and longest possible tower heights can be found
            int min = Math.min(smallest, arr[i + 1] - k);
            int max = Math.max(largest, arr[i] + k);

            //if less than 0 then invalid hence no need to update ans
            if (min < 0)
                continue;
            ans = Math.min(ans, max - min);
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        int arr[]={1,4,7};
        int n=arr.length, k=5;
        solve2(arr, n, k);
    }
    static void sort(int arr[])
    {
        int n=arr.length;
        Random r=new Random();
        for(int i=0;i<n;i++)
        {
            int pos=r.nextInt(n);
            int temp=arr[pos];
            arr[pos]=arr[i];
            arr[i]=temp;
        }
        Arrays.sort(arr);
    }
}