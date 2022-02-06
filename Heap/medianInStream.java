import java.util.Collections;
import java.util.PriorityQueue;

class medianInStream {
    static PriorityQueue<Integer> first = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> second = new PriorityQueue<>();

    // Function to insert heap.
    public static void insertHeap(int x) {
        // add your code here
        if (first.size() == 0 || first.size() <= second.size())
            first.add(x);
        else
            second.add(x);
        balanceHeaps();
    }

    // Function to balance heaps.
    public static void balanceHeaps() {
        // add your code here

        if (first.size() == 1 && second.size() == 0)
            return;
        if (first.size() > 1 && second.size() == 0) {
            second.add(first.poll());
            return;
        }

        if (first.peek() > second.peek()) {
            first.add(second.poll());
            second.add(first.poll());
        }
    }

    // Function to return Median.
    public static double getMedian() {
        // add your code here
        if (first.size() > second.size())
            return first.peek() + 0.0;

        return (first.peek() + second.peek()) / 2.0;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 10, 1, 3 };
        for (int i : arr) {
            insertHeap(i);
            System.out.println((int) getMedian());
        }
    }
}
