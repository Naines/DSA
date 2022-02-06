public class addOne 
{
    /**
     * Method 1: reverse-> add_one-> reverse
     * Method 2: recursive stack ..hence goto last node and simply add.
     */

    /** 
     * METHOD 3:
     * find last node!= 9
     * 3 cases:- 
     * 1. last==null   9 9 9 9 9
     * 2. last is somewhere in between 
     * 3. last is the last node
     *  */
    static Node add_one(Node head)
    {
        Node last=null, curr=head;

        //go till last node
        while(curr.next!=null)
        {
            if(curr.data!=9)
            last=curr;
            curr=curr.next;
        }

        //case 3:
        if(curr.data!=9)
        {
            curr.data++;
            return head;
        }

        if(last==null)
        {
            last=new Node(0);
            last.next=head;
            head=last;
        }
        last.data++;
        last=last.next;
        while(last!=null)
        {
            last.data=0;
            last=last.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(9);
         
        head=add_one(head);
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
