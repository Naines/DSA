import java.util.ArrayDeque;
import java.util.Deque;

public class kthSmallest {
    static int kthSmall(Node root, int k) {
        Node curr = root;
        int count = 0;
        while (curr != null) {
            // if left dont exist , visit and goto right
            if (curr.left == null) {
                count++;
                if (count == k)
                    return curr.data;
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
                    if (count == k)
                        return curr.data;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }

    static int kthsmallest(Node A, int B) {
        return inorder(A, B);
    }

    static int inorder(Node root, int key) {
        Node curr = root;
        int count = 0;
        System.out.println("key = " + key);
        Deque<Node> stk = new ArrayDeque<>();
        while (curr != null || stk.size() > 0) {
            while (curr != null) {
                stk.push(curr);
                curr = curr.left;
            }
            curr = stk.pop();
            System.out.print(curr.data + " ");
            if (++count == key) {
                return curr.data;
            }
            curr = curr.right;
        }
        return -1;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.right = new Node(14);
        root.left.right.left = new Node(10);
        System.out.println(kthSmall(root, 5));

        System.out.println(kthsmallest(root, 5));

    }

    static class Node {
        int data;
        Node left, right;

        Node(int v) {
            data = v;
        }
    }
}
