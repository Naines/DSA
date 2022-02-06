import java.util.PriorityQueue;

public class SmallestRangeInKlists {
    static void solve(int arr[][], int k) {
        int min = Integer.MAX_VALUE;
        int range = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int start = -1, end = -1;
        PriorityQueue<Element> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(new Element(arr[i][0], i, 0));
            max = Math.max(arr[i][0], max);
        }
        while (true) {
            Element temp = pq.poll();
            min = temp.val;

            if (range > max - min) {
                range = max - min;
                start = temp.val;
                end = max;
            }

            if (temp.j + 1 == arr[temp.i].length)
                break;
            temp.val = arr[temp.i][temp.j + 1];
            temp.j++;
            max = Math.max(temp.val, max);

            pq.add(temp);
        }
        System.out.println(start + " " + end);
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 3, 5, 7, 9 }, { 0, 2, 4, 6, 8 }, { 2, 3, 5, 7, 11 } };
        solve(arr, arr.length);
    }

    static class Element implements Comparable<Element> {
        int val, i, j;

        Element(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }

        public int compareTo(Element o) {
            return this.val - o.val;
        }

        public String toString() {
            return this.val + " " + this.i + " " + this.j;
        }
    }
}
