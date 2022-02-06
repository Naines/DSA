import java.util.Stack;

public class SortStack {
    static void sort(Stack<Integer> stk) {
        if (stk.size() == 0)
            return;
        int top = stk.pop();
        sort(stk);
        insert(stk, top);
    }

    static void insert(Stack<Integer> stk, int x) {
        if (stk.isEmpty() || stk.peek() <= x) {
            stk.push(x);
            return;
        }
        int top = stk.pop();
        insert(stk, x);
        stk.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(3);
        stk.push(1);
        stk.push(4);
        stk.push(2);
        stk.push(5);
        sort(stk);
        System.out.println(stk);
    }
}
