public class segregate_zeros_ones_twos {
    static Node segregate(Node head) {
        // add your code here
        int zeros = 0, ones = 0, twos = 0;
        Node curr = head, curr1 = head;
        while (curr != null) {
            if (curr.data == 0)
                zeros++;
            else if (curr.data == 1)
                ones++;
            else
                twos++;
            curr = curr.next;
        }
        while (zeros-- > 0) {
            curr1.data = 0;
            curr1 = curr1.next;
        }
        while (ones-- > 0) {
            curr1.data = 1;
            curr1 = curr1.next;
        }
        while (twos-- > 0) {
            curr1.data = 2;
            curr1 = curr1.next;
        }
        return head;
    }
    
    static Node segregate1(Node head) {
        if (head == null || head.next == null)
            return head;
        Node zero = new Node(-1);
        Node one = new Node(-1);
        Node two = new Node(-1);
        Node zp = zero, op = one, tp = two;
        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zp.next = curr;
                zp = zp.next;
                curr = curr.next;

            } else if (curr.data == 1) {
                op.next = curr;
                op = op.next;
                curr = curr.next;
            } else {
                // curr.data==2
                tp.next = curr;
                tp = tp.next;
                curr = curr.next;
            }

        }
        // attach all 3 lists to zero.next
        // and delete links

        zp.next = (one.next != null) ? one.next : two.next;
        op.next = two.next;
        tp.next = null;
        return zero.next;
    }
    public static void main(String[] args) 
    {
         Node head = new Node(1); 
        head.next = new Node(2); 
        head.next.next = new Node(0); 
        head.next.next.next = new Node(1);
        System.out.println("Linked List Before Sorting");
        printList(head); 
        head = segregate(head);  
        System.out.println("\nLinked List After Sorting");
        printList(head); 
    }
    
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
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
