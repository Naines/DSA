public class removeDupSortedList {
    static void remove(Node head)
    {
        Node curr=head;
        while(curr!=null)
        {
            Node temp=curr;

            //simple iterate if data same
            while(temp!=null && temp.data==curr.data)
            temp=temp.next;

            curr.next=temp;
            curr=curr.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        print(head);
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
