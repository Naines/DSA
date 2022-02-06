public class multiply2lists {
    public static long multiplyTwoLists(Node l1, Node l2) {
        int mod=1_000_000_007;
        long num1 = 0, num2 = 0;
        while(l1!=null || l2!=null)
        {
            if(l1!=null)
            {
                num1=num1*10+l1.data;
                l1=l1.next;
            }
            if(l2!=null)
            {
                num2=num2*10+l2.data;
                l2=l2.next;
            }
            num1=num1%mod;
            num2=num2%mod;
        }
        System.out.println(num1);
        System.out.println(num2);
        return ((num1 * num2) % mod);
    }
    public static void main(String[] args) {
        Node head=new Node(3);
        head.next=new Node(9);

        Node head1=new Node(9);
        head1.next=new Node(6);
        System.out.println(multiplyTwoLists(head, head1));
    }
    static class Node
    {
        int data;
        Node next;
        Node(int v)
        {
            data=v;
        }
    }
}
