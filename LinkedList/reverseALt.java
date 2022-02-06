public class reverseALt {

     public static ListNode solve(ListNode head, int k) {
        boolean flag=true; //true means reverse
        ListNode curr=head, start=head;
        int size=k;
        while(--size>0 && start!=null){
            start=start.next;
        }
        System.out.println("start= "+start.val);
        while(curr!=null){
            if(flag){
                size=k;
                ListNode x=curr;
                while(size-->0 && x!=null){
                    x=x.next;
                }
                print(x);
                curr =reverse(curr, k, x);
                print(curr);
                flag=false;
            }
            else 
            {
                int skip=k*2;
                while(skip-->0 && curr!=null){
                    curr=curr.next;
                }
                flag=true;
            }
        }

        return start;
    }
    static ListNode  reverse(ListNode curr, int k, ListNode x ){
        ListNode prev=x;
        print(prev);
        while(k-->0){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            if(temp==null) break;
            curr=temp;
            
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        print(head);
        ListNode temp=solve(head, 2);
        print(temp);
    }
    static void print(ListNode curr){
        while(curr!=null){
        
            System.out.print(curr.val+" ");
            curr=curr.next;
        }
        System.out.println();
    }
    static class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
    }
}
