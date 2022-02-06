public class heapSort {
    public static void main(String[] args) {
        int arr[] = { 345, 63, 3, 6, 45, 2, 53, 43, 5, 23, 5, 325, 3, 34, 25523 };
        // int arr[] = { 10, 20, 30, 40, 50, 60 };
        heapSort ob = new heapSort();
        ob.sort(arr);

        for (int i : arr)
            System.out.print(i + " ");
    }

    int n;
    int arr[];

    void sort(int arr[]) {
        this.n = arr.length;
        this.arr = arr;
        // heapSort
        // 1.Build max heap
        // 2.heapify by bringing arr[0] to last and decreasing size-1;
        buildHeap();  //n
        int size = n; //nlogn
        for (int i = size - 1; i >= 1; i--) {
            swap(arr, i, 0);
            n--;
            max_heapify(0);
        }
    }

    void buildHeap() {
        for (int i =parent(n-1); i >= 0; i--)
            max_heapify(i);
    }

    void max_heapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            max_heapify(largest);
        }
    }

    void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    int parent(int i){
        return (i-1)/2;
    }
}
