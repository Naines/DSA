import java.util.HashSet;

/**
 * intersectionpointOfTwoLinkedlists
 */
public class intersectionpointOfTwoLinkedlists {
    static Node find(Node h1, Node h2)
    {
        if(h1==null || h2==null)    return null;
        Node a=h1, b=h2;
        while(a!=b)
        {
            if(a==null)
            a=h2;
            else a=a.next;

            if(b==null)
            {
                b=h1;
            }else 
            b=b.next;
           
        }
        return a;
    }
    
    public static Node getIntersectionNode(Node headA, Node headB) {
        int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private static int length(Node node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
    
    public static Node MegeNode(Node n1, Node n2) {
        // define hashset
        HashSet<Node> hs = new HashSet<Node>();
        while (n1 != null) {
            hs.add(n1);
            n1 = n1.next;
        }
        while (n2 != null) {
            if (hs.contains(n2)) {
                return n2;
            }
            n2 = n2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);
        n1.next.next.next.next = new Node(5);
        n1.next.next.next.next.next = new Node(6);
        n1.next.next.next.next.next.next = new Node(7);
        // list 2
        Node n2 = new Node(10);
        n2.next = new Node(9);
        n2.next.next = new Node(8);
        n2.next.next.next = n1.next.next.next;
        print(n1);
        print(n2);
        System.out.println();
        print(MegeNode(n1, n2));

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