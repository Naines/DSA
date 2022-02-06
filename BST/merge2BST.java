public class merge2BST {
    public TreeNode solve(TreeNode A, TreeNode B) {
        if (A == null)
            return B;
        if (B == null)
            return A;
        // if (A == null && B == null)
        // return null;
        if (A != null && B != null)
            A.val += B.val;
        A.left = solve(A.left, B.left);
        A.right = solve(A.right, B.right);
        return A;
    }

    public int isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B != null)
            return 0;
        if (A != null && B == null)
            return 0;
        if (A == null && B == null)
            return 1;
        if (A.val != B.val)
            return 0;
        return isSameTree(A.left, B.left) & isSameTree(A.right, B.right);

    }

    public int isSymmetric(TreeNode A) {
        return isSameTree(A, A);
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int v) {
            val = v;
        }
    }
}
