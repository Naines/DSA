/**
 * detectloop
 */
public class detectloop {

    static void detect(Node head)
    {
        Node slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("here");
                break;
            }
        }
        if (slow != fast)
            System.out.println("no cycle detected");
    }
    static void findstart(Node head)
    {
        Node slow=head, fast=head;
        while(slow!=null && fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                System.out.println("cycle detected");
                find(slow, head);
                delete(slow, head);
                break;
            }
        }
        if(slow!=fast)
        System.out.println("no cycle detected");

    }
    static void find(Node slow, Node start)
    {
        while(start!=slow)
        {
            start=start.next;
            slow=slow.next;
        }
        if(start==slow)
        System.out.println(start.data);
    }
    static void delete(Node slow, Node head)
    {
        //2 cases: a-> slow==head  b-> slow!=head
        if(slow==head)
        {
            while(slow.next!=head)
            slow=slow.next;
        }else
        while(slow.next!=head.next)
        {
            slow=slow.next;
            head=head.next;
        }
        slow.next=null;
    }
    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        head.next.next.next.next.next=new Node(6);
        head.next.next.next.next.next.next=head.next;

        findstart(head);
        print(head);
        // detect(head);


    }
    static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
        }
    }
    static void print(Node head)
    {
        System.out.println("Printing list elements");
        while(head!=null)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
}