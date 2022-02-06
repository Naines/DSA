import java.util.Stack;

public class Evaluation_of_Postfix_Expression {
    static int evaluate(String str) throws Exception {
        Stack<Integer> stk = new Stack<>();
        char ch[] = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {

            System.out.println(stk + " " + ch[i]);
            if (ch[i] == '*')
                stk.push(stk.pop() * stk.pop());
            else if (ch[i] == '+')
                stk.push(stk.pop() + stk.pop());
            else if (ch[i] == '-') {
                int a = stk.pop();
                int b = stk.pop();
                stk.push(b - a);
            } else if (ch[i] == '/') {
                int a = stk.pop();
                int b = stk.pop();
                stk.push(b - a);

            } else
                stk.push(ch[i] - '0');
            System.out.println(stk + " " + ch[i]);
        }
        return stk.peek();

    }

    public static void main(String[] args) throws Exception {
        String str = "231*+9-";
        System.out.println(evaluate(str));
    }
}
