public class First_Last_OCC 
{
    public static int first(int arr[], int x)
    {
        int lb=0, ub=arr.length-1;
        int ans=-1;
        while(lb<=ub)
        {
            int mid=lb+(ub-lb)/2;
            if(arr[mid]<x)
            lb=mid+1;
            else if(arr[mid]>x)
            ub=mid-1;
            else
            {
                ans=mid;
                ub=mid-1; //since 1st occ required
            }
        }
        return ans;
    }
    
    public static int last(int arr[], int x) {
        int lb = 0, ub = arr.length - 1;
        int ans = -1;
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] < x)
                lb = mid + 1;
            else if (arr[mid] > x)
                ub = mid - 1;
            else {
                ans = mid;
                lb=mid+1; // since last occ required
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={0,0,0,0,0,0,1,1,1,1,1,1,1,2};
        System.out.println(first(arr,0));
        System.out.println(last(arr,0));
    }
    
}
