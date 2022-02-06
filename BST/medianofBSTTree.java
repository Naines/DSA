public class medianofBSTTree {
    static int count(Node root)
    {
        Node curr = root;
        int count = 0;
        while (curr != null) {
            // if left dont exist , visit and goto right
            if (curr.left == null) {
                count++;
                curr = curr.right;
            } else {
                Node pred = curr.left;
                while (pred.right != curr && pred.right != null)
                    pred = pred.right;

                // if pred.right==null, set pred.right and goto left
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else // delete pred.right and visit curr and goto right
                {
                    pred.right = null;
                    count++;
                    curr = curr.right;
                }
            }
        }
        return count;
    }
    static int median(Node root)
    {
        int count=count(root);
        Node pred=null,prev=null;//2 pointers to find the median at any given time as c=reqd count.
        int c=0;

        Node curr=root;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                c++;
                if(count%2!=0  && c==(count+1)/2)
                return pred.data;

                else if(count%2==0 && c==(count/2)+1)
                return (prev.data+curr.data)/2;

                prev=curr;
                curr=curr.right;
            }
            else{
                pred=curr.left;
                while(pred.right!=null && pred.right!=curr)
                pred=pred.right;

                if(pred.right==null)
                {
                    pred.right=curr;
                    curr=curr.left;
                }else{
                    pred.right=null;
                    prev=pred;
                    c++;
                    if (count % 2 != 0 && c == (count + 1) / 2)
                        return curr.data;

                    else if (count % 2 == 0 && c== (count / 2) + 1)
                        return (prev.data + curr.data) / 2;
                    prev=curr;
                    curr=curr.right;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Node root=new Node(50);
        root.left=new Node(30);
        root.right=new Node(70);
        root.left.left=new Node(20);
        root.left.right=new Node(40);
        root.right.left=new Node(60);
        root.right.right=new Node(80);
        System.out.println(median(root));
    }
    static class Node{
        int data;
        Node left, right;
        Node(int v)
        {
            data=v;
        }
    }
}
