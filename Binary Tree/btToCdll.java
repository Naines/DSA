/**
 * btToCdll
 */
public class btToCdll {

    static Node concat(Node leftList, Node rightList)
    {
        if(leftList==null)  return rightList;
        if(rightList==null) return leftList;

        //store last pointers of both list
        Node leftLast=leftList.left;
        Node rightLast=rightList.left;

        //join middle
        leftLast.right=rightList;
        rightList.left=leftLast;

        //join first and last
        leftList.left=rightLast;
        rightLast.right=leftList;
        
        return leftList;
    }
    static Node convert(Node root)
    {
        if(root==null)  return null;

        //postorder: left right root
        Node left=convert(root.left);
        Node right=convert(root.right);

        //form single node cyclic
        root.left=root.right=root;

        //concat left with current and then right with resultant
        return concat(concat(root, left), right);
    }
    static void printList(Node head)
    {

        Node itr=head;
        do{
            System.out.print(itr.data+" ");
            itr=itr.right;
        }while(itr!=head);

        System.out.println();

    }
    public static void main(String[] args) {
        Node root;
        root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        root= convert(root);
        printList(root);

    }
    static class Node{
        int data;
        Node left, right;
        Node(int v){
            data=v;
        }
    }
}