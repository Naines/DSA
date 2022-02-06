import java.util.Stack;

public class Celebrity {
    static int check(int mat[][]) {
        int n = mat.length;
        boolean flag = true;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            stk.push(i);
        }

        while (stk.size() > 1) {
            int a = stk.pop();
            int b = stk.pop();

            if (mat[a][b] == 1) {
                stk.push(b);
            } else {
                stk.push(a);
            }
        }

        // this happens when only 2 people are present
        if (stk.isEmpty())
            return -1;

        // till here only 1 person must remain in stack
        int x = stk.pop();

        // check if the one suuspected celeb doesnt know anyone
        for (int i = 0; i < n; i++) {
            if (i != x && (mat[i][x] == 0 || mat[x][i] == 1))
                flag = false;
        }
        if (flag)
            return x;
        return -1;
    }

    public static void main(String[] args) {
        int mat[][] = { { 0, 1, 1, 0 }, { 0, 0, 0, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 0 } };
        // int mat[][]={{0,0,1},{0,0,1},{0,0,0}};
        System.out.println(check(mat));
    }
}
