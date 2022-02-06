/**
 * MergeSort
 */
public class MergeSort {

    static Node mergesort(Node head)
    {
        if(head==null || head.next==null)   return head;
        Node mid=getmid(head);
        Node midnext=mid.next;
        mid.next=null;
        Node left=mergesort(head);
        Node right=mergesort(midnext);
        Node sortedList=merge(left, right);
        return sortedList;
    }
    static Node merge(Node left, Node right)
    {
        if(left==null)  return right;
        if(right ==null )   return left;
        Node res=null;
        if(left.data<=right.data)
        {
            res=left;
            res.next=merge(left.next, right);
        }else{
            res=right;
            res.next=merge(left, right.next);
        }
        return res;
    }
    static Node getmid(Node head)
    {
        if(head.next==null)  return head;
        Node slow=head, fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        Node head=new Node(8);
        head=push(head, 4);
        head=push(head, 9);
        head=push(head, 3);
        head=push(head, 2);
        head=push(head, 10);
        print(head);
        head=mergesort(head);
        print(head);
    }
    static Node push(Node head, int data)
    {
        Node temp=new Node(data);
        temp.next=head;
        return temp;
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
    static void print(Node head)
    {
        while(head!=null)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
}