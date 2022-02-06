package basicTemplates;

public class lowerBound 
{
    static int lower(int arr[], int k, int lb, int ub) {
        int ans = ub + 1;
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] >= k) {
                ans = mid;
                ub = mid - 1;
            } else {
                lb = mid + 1;
            }

        }
        return ans;
    }

    static int numberOfOcc(int arr[], int k, int lb, int ub) {
        int first = lower(arr, k, lb, ub);
        int last = lower(arr, k + 1, lb, ub);
        // System.out.println(first+" "+last);
        return last - first;
    }
    public static void main(String[] args) {
        int arr[]={1,2,2,2,2,4,4,4,4};
        
        System.out.println(numberOfOcc(arr, -10, 0, arr.length-1));
    }
}
