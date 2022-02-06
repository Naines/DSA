public class findMin 
{
    public static int min(int arr[])
    {
        int lb=0,ub=arr.length-1,n=ub;
        int ans=-1;
        while(lb<=ub)
        {
            int mid=lb+(ub-lb)/2;
            if(arr[mid]<=arr[n])
            {
                ans=arr[mid];
                ub=mid-1;
            }
            else
            lb=mid+1;
        }
        return ans;
    }
    public static void main(String[] args) 
    {
        int arr[]={ 3,4,5,1,2};
        System.out.println(min(arr));
    }
    
}
