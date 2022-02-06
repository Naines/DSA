import java.util.Stack;

public class ReverseStack {
    // method 1: o(n^2)-O(1)
    static void reverse(Stack<Integer> stk) {
        if (stk.size() == 0)
            return;

        int top = stk.pop();
        reverse(stk);
        insertBottom(stk, top);
    }

    static void insertBottom(Stack<Integer> stk, int x) {
        if (stk.size() == 0) {
            stk.push(x);
            return;
        }
        int top = stk.pop();
        insertBottom(stk, x);
        stk.push(top);
    }

    static Stack<Integer> temp, stk;

    // // method 2
    // static void reverse(Stack<Integer> stk) {
    // int n = stk.size();
    // temp = new Stack<>();
    // for (int i = 0; i < n; i++)
    // temp.push(stk.pop());

    // // doesnt work
    // // stk = temp; => use stack clone()

    // for (int i : temp)
    // stk.push(i);
    // }

    public static void main(String[] args) {
        stk = new Stack<>();
        stk.push(5);
        stk.push(4);
        stk.push(3);
        stk.push(2);
        stk.push(1);
        System.out.println(stk);
        // int n = stk.size();
        // temp = new Stack<>();
        // for (int i = 0; i < n; i++)
        // temp.push(stk.pop());
        // stk = temp;
        reverse(stk);
        System.out.println(stk);

    }
}
