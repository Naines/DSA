import java.util.Stack;

public class addTwoNumbers_MSBtoLSB {

    static Node add(Node h1, Node h2)
    {
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        
        while(h1!=null)
        {
            s1.push(h1.data);
            h1=h1.next;
        }
        while(h2!=null)
        {
            s2.push(h2.data);
            h2=h2.next;
        }

        int sum=0;
        Node list = new Node(0);

        while(!s1.isEmpty() || !s2.isEmpty())
        {
            if(!s1.isEmpty())   sum+=s1.pop();
            if(!s2.isEmpty())   sum+=s2.pop();

            list.data=sum%10;
            Node prev=new Node(sum/10);
            prev.next=list;
            list=prev;
            sum/=10;
        }
        return list.data==0?list.next: list;
        
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
        
    }}
