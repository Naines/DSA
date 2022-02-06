/**
 * reverse
 */
public class reverse {
    static Node reverselist(Node head) {
        Node prev = null, curr = head, temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
        return head;
    }

    // divide list in two parts - first and rest.
    // from 2nd last node, start process,make cycle and then delete immediate next
    // thus breaking cycle
    // return rest always same
    static Node reverseRec(Node head) {
        if (head == null || head.next == null)
            return head;
        Node rest = reverseRec(head.next);

        head.next.next = head;
        head.next = null;

        return rest;
    }

    // same logic of reversal but splitting nit done
    // instead call recur and wait for last node to be returned..begin ops from
    // penultimate node
    static Node reverseRecur2(Node head) {
        if (head == null)
            return head;
        if (head.next == null)
            return head;

        Node newhead = reverseRecur2(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        print(head);
        head = reverselist(head);
        print(head);
        head = reverseRec(head);
        print(head);
        head = reverseRecur2(head);
        print(head);
    }

    static class Node {
        int data;
        Node next;

        Node(int v) {
            data = v;
        }
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}