package basicTemplates;

/**
 * basicTemplate
 */
public class basicTemplate {

    public static int binSearch(int arr[], int k)
    {
        int lb=0,ub=arr.length -1;
        
        while(lb<=ub)
        {
            int mid = lb + (ub - lb) / 2;
            if(arr[mid]==k)
            return mid;
            else if(arr[mid]>k)
            ub=mid-1;
            else 
            lb=mid+1;
        }
        return -1;
    }
    
    public static int FirstOccurence(int arr[], int k) {
        int lb = 0, ub = arr.length - 1;
        int res = -1;
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;

            if (arr[mid] > k)
                ub = mid - 1;
            else if (arr[mid] < k)
                lb = mid + 1;
            else {
                // continue searching and find the
                // first coocurance by searching in left half
                res = mid;
                ub = mid - 1;
            }
        }
        return res;
    }
    
    public static int LastOccurence(int arr[], int k) {
        int lb = 0, ub = arr.length - 1;
        int res = -1;
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;

            if (arr[mid] > k)
                ub = mid - 1;
            else if (arr[mid] < k)
                lb = mid + 1;
            else {
                // continue searching and find the
                // first coocurance by searching in left half
                res = mid;
                lb=mid+1;
            }
        }
        return res;
    }
    public static void main(String[] args) 
    {
        int arr[]={0,1,1,1,1,1,1,4,4,4,4,4,4,4,5,6,7,8,11};
        int key=4;
        System.out.println(binSearch(arr, key));
        System.out.println("first occurance: " +FirstOccurence(arr, key));
        System.out.println("last occurance : "+ LastOccurence(arr, key));
    }
}