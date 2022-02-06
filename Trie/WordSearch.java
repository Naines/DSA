import java.util.ArrayList;
import java.util.List;

class WordSearch {
    public static void main(String[] args) {
        Solution ob = new Solution();

        // [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
        // words = ["oath","pea","eat","rain"]
        char board[][] = { { 'o', 'a', 'b', 'n' }, { 'o', 't', 'a', 'e' }, { 'a', 'h', 'k', 'r' },
                { 'a', 'f', 'l', 'v' } };
        // String words[] = { "oath", "pea", "eat", "rain" };
        // [["o","a","b","n"],["o","t","a","e"],["a","h","k","r"],["a","f","l","v"]]
        String words[] = { "oa", "oaa" };
        List<String> ans = ob.findWords(board, words);
        for (String s : ans)
            System.out.println(s);
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        ArrayList<String> list = new ArrayList<>();
        TrieNode root = build(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, list);
            }
        }
        return list;
    }

    void dfs(char board[][], int i, int j, TrieNode p, ArrayList<String> list) {

        System.out.println(i + " " + j);
        char ch = board[i][j];

        // base case
        if (ch == '#' || p.kids[ch - 'a'] == null)
            return;

        // self work
        p = p.kids[ch - 'a'];
        if (p.word != "") {
            list.add(p.word);
            p.word = "";
        }

        // recursion
        int dirs[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        board[i][j] = '#';
        for (int dir[] : dirs) {
            int ci = i + dir[0];
            int cj = j + dir[1];
            if (isSafe(ci, cj, board)) {
                dfs(board, ci, cj, p, list);
            }
        }
        board[i][j] = ch;// backtrack

    }

    boolean isSafe(int i, int j, char board[][]) {
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
    }

    TrieNode build(String words[]) {
        TrieNode root = new TrieNode();
        for (String s : words) {
            TrieNode curr = root;
            for (char c : s.toCharArray()) {
                if (curr.kids[c - 'a'] == null)
                    curr.kids[c - 'a'] = new TrieNode();
                curr = curr.kids[c - 'a'];
            }
            curr.word = s;
        }
        return root;
    }

    static class TrieNode {
        String word = "";
        TrieNode kids[] = new TrieNode[26];
    }
}
