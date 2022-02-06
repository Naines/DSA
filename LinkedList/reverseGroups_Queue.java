import java.util.ArrayDeque;
import java.util.Deque;

public class reverseGroups_Queue {
    static Node reverse(Node head, int k)
    {
        Deque<Node> q=new ArrayDeque<>();
        Node curr=head;
        while(curr!=null)
        {
            int i=0;
            while(curr!=null)
            {
                //add nodes
                i=0;
                while(i<k)
                {
                    if(curr==null)  break;
                    q.addLast(curr);
                    curr=curr.next;
                    i++;
                }
                //reverse here
                while(!q.isEmpty())
                {
                    Node front=q.peekFirst();
                    Node last=q.peekLast();

                    //swap data values
                    int temp=front.data;
                    front.data=last.data;
                    last.data=temp;

                    if(!q.isEmpty())q.removeFirst();
                    if(!q.isEmpty())q.removeLast();
                }
            }
        }

        return head;

    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head = reverse(head, 3);
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
