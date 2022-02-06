public class reverseGroups {

    static Node reverse(Node head, int k)
    {
        if(head==null)  return null;
        Node curr=head, prev=null, temp=null;
        int count=0;
        while(count<k && curr!=null)
        {
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            count++;
        }

        if(curr!=null)
        head.next=reverse(curr, k);

        return prev;

    }
    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        head= reverse(head, 1);
        print(head);
    }
    static class Node{
        int data;
        Node next;
        Node(int v)
        {
            data=v;
        }
    }
    static void print(Node curr)
    {
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
}
