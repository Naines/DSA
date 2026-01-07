public class Test {
  int msf = -100000;

  public static void main(String[] args) {
    int arr[] = { 3, 2, 4, 5, 1 };
    Test ob = new Test();
    Node root = ob.makeTree(arr);
    ob.inorder(root);
    System.out.println();
    ob.preorder(root);
    System.out.println();
    // System.out.println("IS VALID BST: " + ob.isValidBST(root, Integer.MIN_VALUE,
    // Integer.MAX_VALUE));

    Node r2 = new Node(5);
    r2.left = new Node(6);
    r2.left.left = new Node(4);
    r2.left.left.left = new Node(4);
    // r2.left.right = new Node(100);
    r2.right = new Node(-10);
    // System.out.println(ob.isValidBST(r2, -100, 100));

    // System.out.println("Sum = " + ob.sum(root));

    // find a largest subtree Sum
    System.out.println("Largest subtree Sum = " + ob.sum(r2));
    System.out.println(ob.msf);

    // height of binary tree
    System.out.println("HEIGHTS:");
    System.out.println(ob.height(r2));
    System.out.println(ob.height(root));

    // diameter of tree = lHeight + rHeight +1
    System.out.println(ob.height(root.left) + ob.height(root.right) + 1);

  }

  // Sum of Tree
  int sum(Node n) {
    if (n == null)
      return 0;
    int currSum = n.data + sum(n.left) + sum(n.right);
    System.out.println("IN AT NODE " + n.data);
    System.out.println("CURRSUM = " + currSum);
    msf = Math.max(msf, currSum);
    System.out.println("MSF: " + msf);
    return currSum;
  }

  int height(Node n) {
    if (n == null)
      return 0;
    return Math.max(height(n.left), height(n.right)) + 1;
  }

  //

  Node makeTree(int arr[]) {
    Node root = new Node(arr[0]);
    for (int i = 1; i < arr.length; i++) {
      insert(arr[i], root);
    }
    return root;
  }

  Node insert(int x, Node n) {
    if (n == null)
      return new Node(x);
    if (n.data < x)
      n.right = insert(x, n.right);
    else if (n.data > x)
      n.left = insert(x, n.left);
    return n;
  }

  void inorder(Node root) {
    // left -root-right
    if (root == null)
      return;
    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
  }

  void preorder(Node root) {
    // root -left - right
    if (root == null)
      return;
    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
  }

  static int subTreeSum(Node root) {
    if (root == null)
      return 0;
    int leftSum = subTreeSum(root.left);
    int rightSum = subTreeSum(root.right);
    return leftSum + rightSum;
  }

  boolean isValidBST(Node n, int min, int max) {
    // check for each node if each node val is correct
    // n.val < n.right.val and n.val > n.left.val

    if (n == null)
      return true;

    if (n.data < min || n.data > max)
      return false;
    // left -> decrease max
    // right -> increase min
    return isValidBST(n.left, min, n.data - 1) && isValidBST(n.right, n.data + 1, max);
  }

  //
  static class Node {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
    }

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }
}
