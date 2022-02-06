public class flattenLinkedList {
    Node head;
    public static void main(String[] args) {
        /*
         * Let us create the following linked list 5 -> 10 -> 19 -> 28 
         *                                          | | | | 
         *                                          7 20 22 35 
            *                                           | | |
            *                                           8 50 40 
            *                                           | | 
            *                                           30 45
         */
        flattenLinkedList L=new flattenLinkedList();
        L.head = L.push(L.head, 30);
        L.head = L.push(L.head, 8);
        L.head = L.push(L.head, 7);
        L.head = L.push(L.head, 5);

        L.head.right = L.push(L.head.right, 20);
        L.head.right = L.push(L.head.right, 10);

        L.head.right.right = L.push(L.head.right.right, 50);
        L.head.right.right = L.push(L.head.right.right, 22);
        L.head.right.right = L.push(L.head.right.right, 19);

        L.head.right.right.right = L.push(L.head.right.right.right, 45);
        L.head.right.right.right = L.push(L.head.right.right.right, 40);
        L.head.right.right.right = L.push(L.head.right.right.right, 35);
        L.head.right.right.right = L.push(L.head.right.right.right, 20);
        L.head = L.flatten(L.head);

        L.printList();
    }
    
    Node push(Node head_ref, int data)
    {
        Node new_node = new Node(data); 
        new_node.down = head_ref;
        head_ref = new_node;
        return head_ref;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.down;
        }
        System.out.println();
    }

    static class Node{
        int data;
        Node right, down;
        Node(int v)
        {
            data=v;
        }
    }


    Node flatten(Node head)
    {
        if(head==null || head.right==null)  return head;

        head.right=flatten(head.right);//recursive step

        head=merge(head, head.right);//merge head and head.right//to downlinks

        return head;
    }
    Node merge(Node a, Node b)
    {
        if(a==null) return b;
        if(b==null) return a;
        Node res=null;
        if(a.data<b.data)
        {
            res=a;
            res.down=merge(a.down, b);
        }else{
            res=b;
            res.down=merge(a, b.down);
        }
        return res;
    }
}
