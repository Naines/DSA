public class reverseGroupsitr {
    static Node reverse(Node head, int k)
    {
        Node prev=null, next=null, curr=head;
        Node newhead=null, tail=null;
        while(curr!=null)
        {
            int t=k;
            Node jointo=curr;
            prev=null;
            //make disconnected(from both sides) list
            while(t-->0 && curr!=null)
            {
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }

            //one time op, newhead=prev
            if(newhead==null)
            newhead=prev;

            if(tail!=null)
            tail.next=prev;

            tail=jointo;
        }
        return newhead;
    }
    //3 2 1  6 5     4     7 8 
    //              tail     curr
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node dup=head;
        dup = reverse(head, 3);
        print(dup);
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
