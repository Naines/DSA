public class mergeKLists_divideAndConquer {
    public static void main(String args[]) 
    {
        int k = 3; // Number of linked lists
        //int n = 4; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        Node arr[] = new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        // Merge all lists
         Node head = mergeKLists(arr, k - 1);
        printList(head);
    }
    static Node mergeKLists(Node arr[], int last)
    {
        int i, j;
        while(last!=0)
        {
             i=0; j=last;
            while(i<j)
            {
                arr[i]=merge(arr[i], arr[j]);
                i++;j--;
                if(i>=j)
                last=j;
            }
        }
        return arr[0];
    }
    static Node merge(Node a, Node b)
    {
        if(a==null) return b;
        if(b==null) return a;
        Node res=null;
        if(a.data< b.data)
        {
            res=a;
            res.next=merge(a.next, b);

        }else{
            res=b;
            res.next=merge(a, b.next);
        }
        return res;
    }
    static class Node{
        int data;
        Node next;
        Node(int v)
        {
            data=v;
        }
    }
    static void printList(Node head)
    {
        
        for(;head!=null; head=head.next)
        {
            System.out.print(head.data+" ");
        }
        System.out.println();
    }
}
