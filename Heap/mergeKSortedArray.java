import java.util.PriorityQueue;

public class mergeKSortedArray {

    static int[] merge(int arr[][], int k) {
        int ans[] = new int[k * k];
        PriorityQueue<Element> pq = new PriorityQueue<>();
        int x = 0;
        for (int i = 0; i < k; i++) {
            pq.add(new Element(arr[i][0], i, 0));
        }
        while (!pq.isEmpty()) {
            Element curr = pq.poll();
            ans[x++] = curr.val;
            int row = curr.row;
            int col = curr.col;
            if (col < k - 1)
                pq.add(new Element(arr[row][col + 1], row, col + 1));

        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 }, { 2, 2, 3, 4 }, { 5, 5, 6, 6 }, { 7, 8, 9, 9 } };
        int ans[] = merge(arr, arr.length);
        for (int i : ans)
            System.out.print(i + " ");
    }

    static class Element implements Comparable<Element> {
        int row, col, val;

        Element(int v, int r, int c) {
            this.val = v;
            this.row = r;
            this.col = c;
        }

        public int compareTo(Element o) {
            return this.val - o.val;
        }
    }
}
