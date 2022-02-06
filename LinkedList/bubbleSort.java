public class bubbleSort {
    
    public static  Node sortList(Node head) 
    {

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

   
    public static void main(String[] args) {
        Node head=new Node(10);
        head.next=new Node(13);
        head.next.next=new Node(11);
        head.next.next.next=new Node(3);

        print(head);
        head=sortList(head);
        print(head);

    }
    
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static int count=0;
    static void print(Node head) {
        System.out.println("Printing list elements");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
            count++;
        }
        System.out.println();
    }
}
