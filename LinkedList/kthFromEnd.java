public class kthFromEnd {
    static void find(Node head, int k)
    {
        Node main=head, ref=head;
        while(k-->0)
        {
            ref=ref.next;
        }
        while(ref!=null)
        {
            ref=ref.next;
            main=main.next;
        }
        System.out.println(main.data);
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        int k=4;
        print(head);
        find(head, k);

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
