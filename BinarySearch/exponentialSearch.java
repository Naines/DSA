public class exponentialSearch 
{
    public static int expSearch(int arr[],int k)
    {
        if(arr[0]==k) //found at 1st pos
        return 0;

        int i=1;
        while(i<arr.length && arr[i]<=k)
        i=i*2;

        System.out.println(i/2+" "+Math.min(i, arr.length-1));
        return bSearch(arr, i/2, Math.min(i,arr.length-1), k);

    }
    public static int bSearch(int arr[], int lb, int ub, int key)
    {
        if(lb<=ub)
        {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] == key)
                return mid;

            else if (arr[mid] > key) // discard right
                return bSearch(arr, lb, mid - 1, key);

            else // arr[mid]<key //discard left
               return bSearch(arr, mid + 1, ub, key);
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={0,1,2,3,4,5,6,7,8,9,10,11};
        System.out.println(expSearch(arr, 6)); 
    }
}
