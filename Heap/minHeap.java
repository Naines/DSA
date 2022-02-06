class minHeap {
    public static void main(String[] args) {
        Heap_min heap = new Heap_min(); //default size=10
        heap.add(5);
        heap.add(10);
        heap.add(2);
        heap.add(1);
        heap.display();
        System.out.println(heap.poll());
        System.out.println(heap.poll());

        // update ops
        heap.display();
        heap.decreaseKey(1, -1);// index, new value
        heap.display();
        // delete ops
        heap.deleteKey(0);
        heap.display();

    }

    static class Heap_min {

        // zero based indexing used
        int arr[], size, cap = 10;

        Heap_min() {
            this.size = 0;
            this.arr = new int[cap];
        }

        Heap_min(int size) {
            if (size > cap) {
                cap = size;
            }
            this.size = 0;
            this.arr = new int[cap];
        }

        void add(int x) {
            if (size + 2 == cap) {
                System.out.println("Heap full");
                return;
            }
            arr[size] = x;
            size++;

            // maintain heap property
            for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i];) {
                swap(arr, i, parent(i));
                i = parent(i);
            }
        }

        // min_heapify assumes only i doesn't follow heap prop
        void min_heapify(int i) {
            int left = left(i), right = right(i), smallest = i;
            // find min index of the three
            if (left < size && arr[left] < arr[smallest])
                smallest = left;
            if (right < size && arr[right] < arr[smallest])
                smallest = right;

            if (smallest != i) {
                swap(arr, i, smallest);
                min_heapify(smallest);
            }

        }

        void buildHeap() {

            for (int i = parent(size - 1); i >= 0; i--) {
                min_heapify(i);
            }
        }

        int poll() {
            if (size == 0) {
                System.out.println("Heap Empty");
                return Integer.MIN_VALUE;
            }

            if (size == 1) {
                return arr[size--];
            }

            swap(arr, 0, size - 1);
            size--;
            min_heapify(0);
            return arr[size];
        }

        void decreaseKey(int i, int x) {
            arr[i] = x;

            // maintain heap property
            // just look at top
            while (i != 0 && arr[parent(i)] > arr[i]) {
                swap(arr, parent(i), i);
                i = parent(i);
            }

        }

        void deleteKey(int i) {
            decreaseKey(i, Integer.MIN_VALUE);
            poll();
        }

        /////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////
        int left(int i) {
            return 2 * i + 1;
        }

        int right(int i) {
            return 2 * i + 1;
        }

        int parent(int i) {
            return (i - 1) / 2;
        }

        void swap(int arr[], int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        void display() {
            for (int i = 0; i < size; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}