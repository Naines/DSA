public class SearchInSorted 
{
    public static int search(int arr[], int key)//make ops only on sorted part of array 
    {
        // 4,5,6,7,8,1,2,3
        // 0 1 2 3 4 5 6 7
        int lb=0,ub=arr.length-1;
        while(lb<=ub)
        {
            int mid=lb+(ub-lb)/2;
            if(key==arr[mid])
            return mid;
            else if(arr[mid]<=arr[ub])//right half sorted
            {
                if(key>arr[mid] && key<=arr[ub]) //present here
                lb=mid+1;
                else //not present here
                ub=mid-1;
            }
            else //left half definitely sorted
            {
                if(key<arr[mid] && key>=arr[lb])//present here
                ub=mid-1;
                else //not present in this range
                lb=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={4,4,4,5,5,6,7,8,1,2,3,4};
        System.out.println(search(arr,4));
        System.out.println(search(arr, 5));
        // System.out.println(search(arr, 8));
        // System.out.println(search(arr,1));
        // System.out.println(search(arr, 3));
        // System.out.println(search(arr,4));
    }
    
}
