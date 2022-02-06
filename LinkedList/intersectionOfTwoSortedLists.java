public class intersectionOfTwoSortedLists {
    public static Node find(Node head1, Node head2) 
    {
        
        Node list = null, head = null;
        while (head1 != null && head2 != null) 
        {
            if (head1.data == head2.data) {
                if (list == null) 
                {
                    head = new Node(head1.data);
                    list = head;
                } else {
                    list.next = new Node(head1.data);
                    list = list.next;
                }
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.data < head2.data)
                head1 = head1.next;
            else
                head2 = head2.next;

        }
        return head;

    }
    
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);
        head2.next.next.next.next.next = new Node(6);

        print(head1);
        print(head2);
        Node head3=find(head1, head2);
        print(head3);

    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static void print(Node head) {
        System.out.println("");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

    }
}
