import java.util.HashSet;
import java.util.Set;

class detectCycle
{
    static boolean isCycle(Node n)
    {
        if (n == null || n.next == null)
            return false;
        Node slow = n;
        Node fast = n;
        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
    static boolean isCycle_Set(Node n)
    {
        if(n==null || n.next==null )
        return false;

        Set<Node> s=new HashSet<>();
        while(n!=null)
        {
            if(!s.contains(n))
            s.add(n);
            else 
            return true;

            n=n.next;
        }
        return false;
    }
    public static void main(String[] args) 
    {
        
        Node head=new Node(0);
        head.next=new Node(1 );
        head.next.next=new Node(2);
        head.next.next.next=new Node(3);
        head.next.next=head.next;

        //2 ways
        System.out.println(isCycle(head));
        System.out.println(isCycle_Set(head));
        
        
    }
    static class Node{
        int data;
        Node next;
        Node(int v)
        {
            data=v;
        }
    }
    
}
