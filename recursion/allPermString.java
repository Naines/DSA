/**Backtracking 1. */
public class allPermString {
    static void allperm(int arr[], int size, int index)
    {
        if(index==size)
        {
            for(int i: arr) System.out.print(i+" ");
            System.out.println();
            return;
        }

        for(int i=index;i<size;i++)
        {
            swap(arr, i, index);
            allperm(arr, size, index+1);
            swap(arr, i, index);
        }
    }
    static void swap(int arr[], int a, int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3};
        allperm(arr, arr.length, 0);
    }
}
