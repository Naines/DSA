public class lastToFirst {
    static Node rotate(Node head)
    {
        if(head==null || head.next==null)  return head;
        Node curr=head,last=null;
        while(curr.next.next!=null)
        {
            curr=curr.next;
        }
        last=curr.next;
        curr.next=null;
        last.next=head;
        head=last;
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        
        head=rotate(head);
        head=rotate(head);
        head=rotate(head);
        head=rotate(head);
        print(head);
    }

    static class Node {
        int data;
        Node next;

        Node(int v) {
            data = v;
        }
    }

    static void print(Node curr) {
        System.out.println();
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
