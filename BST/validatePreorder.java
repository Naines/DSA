import java.util.Stack;

public class validatePreorder {
    /** 40, 30, 35, 80, 100 */

    // root is actually assumed as parent node value
    static int root = Integer.MIN_VALUE;

    static boolean validate(int pre[]) {
        int n = pre.length;
        root = pre[0];
        Stack<Integer> stk = new Stack<>();
        for (int i = 1; i < n; i++) {
            if (pre[i] < root) {
                if (!stk.isEmpty())
                    System.out.println("peek= " + stk.peek() + " i= " + i);

                while (!stk.isEmpty() && stk.peek() < pre[i])
                    root = stk.pop();
            }
            System.out.println("root= " + root + " i= " + i);
            stk.push(pre[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        // int pre[] = { 40, 30, 35, 80, 100 };
        int pre[] = { 50, 20, 10, 30, 100, 60, 120 };
        System.out.println(validate(pre));
    }
}
