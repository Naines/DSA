public class deleteNodesHavingGreaterRight 
{
    static Node solve(Node head)
    {
        // 10 - 20 - 12 - 4 - 5
        // 20- 12 -5
        if (head.next == null)
            return head;
        Node temp = solve(head.next);
        if (temp.data > head.data)
            return temp;
        else
            head.next = temp;
        return head;
    }
    public static void main(String[] args) {
        Node head=new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(12);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        head=solve(head);
        print(head);

    }
    static void print(Node head)
    {
        while(head!=null)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
    static class Node
    {
        Node next;
        int data;
        Node(int v)
        {
            data=v;
        }
    }
}
