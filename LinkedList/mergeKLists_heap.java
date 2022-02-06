import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKLists_heap {
    static Node mergeKLists(Node[] arr, int last) {

        if (arr == null || arr.length == 0)
            return arr[0];

        Node dummy = new Node(0);
        Node tail = dummy;

        PriorityQueue<Node> pq = new PriorityQueue<Node>(last, new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.data - b.data;
            }
        });

        // inserting first nodes of each chains/lists
        for (Node n : arr) {
            if (n != null) {
                pq.add(n);

            }
        }

        while (!pq.isEmpty()) {
            tail.next = pq.poll();// 1 drecraesed , so 1 can be added
            tail = tail.next;

            if (tail.next != null) // add from the same list form where added to the dummy list
                pq.add(tail.next);

            // if(tail.next==null)list ends so dont do any ops with this list
        }
        return dummy.next;

    }

    public static void main(String args[]) {
        int k = 3; // Number of linked lists
        // int n = 4; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        Node arr[] = new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        // Merge all lists
        Node head = mergeKLists(arr, k - 1);

        printList(head);
    }

    static class Node {
        int data;
        Node next;

        Node(int v) {
            data = v;
        }
    }

    static void printList(Node head) {

        for (; head != null; head = head.next) {
            System.out.print(head.data + " ");
        }
        System.out.println();
    }
}
