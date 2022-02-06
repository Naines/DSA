public class findMinMaxInCircularRot 
{
    public static int min(int arr[], int lb, int ub)
    {
        while(lb<=ub)
        {
            // if sorted
            if (arr[lb] <= arr[ub])
                return arr[lb];

            int mid = (lb + ub) / 2;
            int next=(mid+1)%arr.length;
            int prev=(mid-1+arr.length)%arr.length;

            if(arr[mid]<arr[next] && arr[mid]<arr[prev])
            return arr[mid];

            if(arr[mid]<=arr[ub])//discard arr[mid...ub] and search in arr[lb...mid]
            ub=mid-1;

            else if(arr[mid]>=arr[lb])// discard arr[lb..mid] as ele not inside=> sorted in anticlock
            lb=mid+1;
        }
       return -1;
        
    }
    
    public static int max(int arr[], int lb, int ub) {
        while (lb <= ub) {
            // if sorted
            if (arr[lb] <= arr[ub])
                return arr[ub];

            int mid = (lb + ub) / 2;
            int next = (mid + 1) % arr.length;
            int prev = (mid - 1 + arr.length) % arr.length;

            if (arr[mid] > arr[next] && arr[mid] > arr[prev])
                return arr[mid];

            if (arr[mid] <= arr[ub]) // search in this range
                lb=mid+1;

            else if (arr[mid] >= arr[lb]) //discard this range as ele not inside 
                lb=mid+1;
        }
        return -1;

    }
    
    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 };

        System.out.println(min(arr , 0 , arr.length-1));

        System.out.println(max(arr, 0 , arr.length-1));
        
    }
}
