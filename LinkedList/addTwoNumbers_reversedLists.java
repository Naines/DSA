public class addTwoNumbers_reversedLists 
{
    static Node add(Node h1, Node h2)
    {
        Node h3=new Node(0);
        Node curr=h3;
        int carry=0;
        while(h1!=null && h2!=null)
        {
            int sum=h1.data+h2.data+carry;
            curr.next=new Node(sum%10);
            carry=sum/10;
            curr=curr.next;
            h1=h1.next;
            h2=h2.next;
        }
        
        while (h1 != null ) {
            int sum = h1.data + carry;
            curr.next = new Node(sum % 10);
            carry = sum / 10;
            curr = curr.next;
            h1 = h1.next;
        }
        while ( h2 != null) {
            int sum =h2.data + carry;
            curr.next = new Node(sum % 10);
            carry = sum / 10;
            curr = curr.next;
            h2 = h2.next;
        }
        if(carry>0)
        curr.next=new Node(carry);
        
        return h3.next;
    }
    static Node add1(Node h1, Node h2)
    {
        Node dummy=new Node(-1);
        Node newhead=dummy;
        int carry=0;
        while(h1!=null || h2!=null || carry!=0)
        {
            int sum= (h2!=null?h2.data:0) + (h1!=null? h1.data:0 )+carry;
            carry=sum/10;
            dummy.next=new Node(sum%10);
            dummy=dummy.next;

            h1= (h1==null)? h1: h1.next;
            h2= (h2==null)? h2: h2.next;
        }

        return newhead.next;
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
        Node head3= add(head1, head2);
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
