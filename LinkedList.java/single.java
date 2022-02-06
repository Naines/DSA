class single{
    static class Node{
        int data;
        Node next;
        Node(int v)
        {
            data=v;
        }
    }
    static void print(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data+" ");
            n=n.next;
        }
    }
    static Node insert(Node n, int v)
    {
        if(n==null)
        return new Node(v);
        Node temp=n;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=new Node(v);
        return n;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        Node head=null;
        for(int i:arr)
        head=insert(head, i);
        print(head);
    }
}