
public class SubsetSum_ 
{
    static int equalPartition(int n, int arr[]) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 2 != 0)
            return 0;
        if (find(arr, n, sum / 2))
            return 1;
        return 0;
    }

    static boolean find(int arr[], int last, int sum) {
        if (sum == 0)
            return true;
        if (last == 0)
            return false;
        if (sum >= arr[last - 1]) {
            return find(arr, last - 1, sum - arr[last - 1]) || find(arr, last - 1, sum);
        } else
            return find(arr, last - 1, sum);
    }
    public static void main(String[] args) {
        int arr[]={1,5,11,15};
        if(equalPartition(arr.length, arr)==0)
        System.out.println("NO");
        else
        System.out.println("YES");
    }
}