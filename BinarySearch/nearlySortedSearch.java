public class nearlySortedSearch 
{
    public static int search(int arr[], int x)
    {
        int lb=0, ub=arr.length-1;
        while(lb<=ub)
        {
            int mid=lb+(ub-lb)/2;
            if (arr[mid] == x)
                return mid;
            else if ( mid-1>=lb && arr[mid - 1] == x)
                return mid - 1;
            else if ( mid+1<= ub && arr[mid + 1] == x)
                return mid + 1;

            else if(arr[mid]>x)
            ub=mid-2;
            else //(arr[mid]<x)
            lb=mid+1;
          }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={2,1,3};
        
        System.out.println(search(arr,10)+" ");
    }
    
}
