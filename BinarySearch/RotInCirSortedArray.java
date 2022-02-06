public class RotInCirSortedArray {
    public static int numRot(int arr[], int lb, int ub)
    {
        while(lb<=ub)
        {
            if(arr[lb]<=arr[ub])
            return lb;

            int mid=(lb+ub)/2;

            int next=(mid+1)%arr.length;
            int prev=(mid-1+arr.length)%arr.length;

            if(arr[mid]< arr[next] && arr[mid]<arr[prev])
            return mid;

            else if(arr[mid] <=arr[ub]) //since sorted and ele not inside (as anticlk rot) discard
            ub=mid-1;

            else if(arr[mid]>=arr[lb]) // since sorted and ele not inside (as anticlk rot) discard
            lb=mid+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={2,3, 4, 5, 6, 7, 8,9 ,10,1 };
        System.out.println("Number of rotations: "+numRot(arr,0,arr.length-1));
    }
}
