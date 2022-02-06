public class findpeak {
    public static int peak(int arr[]) {
        return peak(arr, 0, arr.length - 1);
    }

    public static int peak(int arr[], int lb, int ub) {
        int mid = lb + (ub - lb) / 2;

        // case 1: mid greater than both neighbours
        if ((mid == 0 || arr[mid - 1] < arr[mid]) && (mid == arr.length - 1 || arr[mid + 1] < arr[mid]))
            return mid;

        // case 2: mid-1 greater than mid search in left
        else if (mid - 1 >= lb && arr[mid - 1] > arr[mid])
            return peak(arr, lb, mid - 1);

        // case 3:mid+1 greater than mid search in right
        else
            return peak(arr, mid + 1, ub);

    }
    static int findPeak(int arr[], int n){
        int low=0, high=n-1;
        if(arr[low]<arr[high])return high;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid==n-1 || arr[mid]>arr[mid+1]) && (mid==0 || arr[mid-1]<arr[mid])){
                return mid;
                
            }else if(mid+1<=high && arr[mid]<arr[mid+1]){
                //increasing then search right
                low=mid+1;
            }
            else{
                high=mid-1;
            } //search left
        }
        return -1;
    }
    static  int bs(int arr[], int low, int high, int key){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==key)return mid;
            else if(arr[mid]<key)low=mid+1;
            else high=mid-1;
        }
        return -1;
        
    }
    static int revBS(int arr[], int low, int high, int key){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==key)return mid;
            else if(arr[mid]>key)low=mid+1;
            else high=mid-1;
        }
        return -1; 
    }
     static int search(final int[] A, int B) {
        int n=A.length;
        int peak=findPeak(A, n);
        // System.out.println(peak);
        int fwd=bs(A, 0, peak, B);
        if(fwd!=-1)return fwd;
        int rev=revBS(A, peak+1, n-1, B);
        
        if(rev!=-1)return rev;
        
        return -1;
    }
    public static void main(String[] args) {
        // int arr[] = { 7, 4, 3, 2 };
        int arr[] = { 11,12,45,676, 7, 4, 3, 2};
        System.out.println(peak(arr));
        System.out.println(findPeak(arr, arr.length));
        System.out.println(search(arr, 11));
        System.out.println(search(arr, 2));
        System.out.println(search(arr, 45));
    }

}
