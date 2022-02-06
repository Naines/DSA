import java.util.Arrays;

public class First_Last_occ_mod 
{
    public static int first(int arr[], int x)
    {
        int lb=0, ub=arr.length-1, ans=arr.length;
        while(lb<=ub)
        {
            int mid=lb+(ub-lb)/2;
            if(arr[mid]>=x)
            {
                ans=mid;
                ub=mid-1;
            }
            else
            lb=mid+1;
        }
        return ans;
    }
    public static int[] find(int arr[], int x)
    {
        int first=first(arr, x);
        int last=first(arr, x+1)-1;
        return new int[]{first, last};
    }
    public static void main(String[] args) {
        int arr[]={0,1,2,3,3,3,3,3,3,3,3,3,3,3,5};
        System.out.println(Arrays.toString(find(arr, 3)));
    }
}
