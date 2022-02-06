package practise;

import java.util.ArrayList;
import java.util.Arrays;

public class nQueens {
    boolean board[][];
    ArrayList<ArrayList<String>> ans = new ArrayList<>();

    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        board = new boolean[n][n];
        backtrack(board, n, 0);
        return ans;
    }

    void backtrack(boolean board[][], int n, int cr) {
        if (cr == n) {
            print(board, n);
            return;
        }
        // System.out.println(Arrays.deepToString(board));
        for (int i = 0; i < n; i++) {

            // System.out.println(isLegal(board, n, cr, i));
            if (isValid(board, n, cr, i)) {
                board[cr][i] = true;
                backtrack(board, n, cr + 1);
                board[cr][i] = false;
            }

        }
    }

    boolean isValid(boolean mat[][], int n, int i, int j) {
        // overhead
        for (int x = i - 1; x >= 0; x--)
            if (mat[x][j] == true)
                return false;

        // diagonal left
        for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--) {
            if (mat[x][y] == true)
                return false;
        }

        // diagonal right
        for (int x = i - 1, y = j + 1; y < n && x >= 0; x--, y++) {
            if (mat[x][y] == true)
                return false;
        }

        return true;
    }

    static boolean isLegal(boolean grid[][], int n, int r, int c) {
        // overhead attack check
        for (int i = r - 1; i >= 0; i--)
            if (grid[i][c])
                return false;

        // upper left diagonal
        for (int i = r - 1, j = c - 1; j >= 0 && i >= 0; i--, j--)
            if (grid[i][j])
                return false;
        // upper right diagonal
        for (int i = r - 1, j = c + 1; j < n && i >= 0; i--, j++)
            if (grid[i][j])
                return false;
        // no need for sideways check here
        return true;
    }

    void print(boolean board[][], int n) {
        ans.add(new ArrayList<String>());
        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = 0; j < n; j++) {
                if (board[i][j] == true)
                    str += 'Q';
                else
                    str += '.';
            }
            ans.get(ans.size() - 1).add(str);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        nQueens ob = new nQueens();
        System.out.println(ob.solveNQueens(n));
    }
}
