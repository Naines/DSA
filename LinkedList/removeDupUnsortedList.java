public class removeDupUnsortedList {
    public static Node sortList(Node head) {

        // Node current will point to head
        Node current = head, index = null;

        int temp;

        if (head == null) {
            return null;
        } else {
            while (current != null) {
                // Node index will point to node next to
                // current
                index = current.next;

                while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }

                    index = index.next;
                }
                current = current.next;
            }
        }
        return head;
    }
    
    static void remove(Node head) {
        Node curr = head;
        while (curr != null) {
            Node temp = curr;

            // simple iterate if data same
            while (temp != null && temp.data == curr.data)
                temp = temp.next;

            curr.next = temp;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(6);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(6);
        print(head);
        head=sortList(head);
        remove(head);
        print(head);

    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static void print(Node head) {
        System.out.println("Printing list elements");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

}
