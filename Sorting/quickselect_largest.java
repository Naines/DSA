public class quickselect_largest {
    static void findk(int arr[], int s, int e, int k) 
    {
        int pivot=partition(arr, s, e);

        if(k-1==pivot)
        System.out.println(arr[pivot]);
        else
        if(k-1>pivot)//right as i want worse ans
        findk(arr, pivot+1, e, k);
        else //i need better ans 
        findk(arr, s, pivot-1, k);
        
    }

    static int partition(int arr[], int s, int e) 
    {
        
        int pivot = arr[e];
        int i = s - 1, j = s;
        for (j = s; j < e; j++) {
            if (arr[j] >= pivot) {
                i++;
                // swap i, j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap pivot to actual placce i.e; i+1
        int temp = arr[e];
        arr[e] = arr[i + 1];
        arr[i + 1] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 344, 6534, 543, 52, 2, 6, 526, -432, 234525, -4325, -234 };
        findk(arr, 0, arr.length-1, 3);
        findk(arr, 0, arr.length-1, 1);
        findk(arr, 0, arr.length-1, 3);
        findk(arr, 0, arr.length-1, 4);
        findk(arr, 0, arr.length-1, 12);
        
        quicksort.ruffle_sort(arr);
        for (int i : arr)
            System.out.print(i + " ");

    }
}
