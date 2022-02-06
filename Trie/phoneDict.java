import java.util.ArrayList;
import java.util.List;

public class phoneDict {
    static List<List<String>> ans = new ArrayList<>();

    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        String words[] = { "geeksforgeeks", "geeksfortest", "geeikistest" };

        String key = "geeips";

        for (String s : words) {
            add(root, s);
        }

        for (int i = 0; i <= key.length(); i++) {
            search(root, key.substring(0, i));
        }

        for (int i = 1; i <= key.length(); i++) {
            int size = ans.get(i).size();
            for (int j = 0; j < size; j++) {
                if (ans.get(i).get(j).equals("0")) {
                    System.out.print("0");
                    continue;
                }
                System.out.print(key.substring(0, i) + ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
        // System.out.println(ans);

    }

    static void add(TrieNode root, String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.kids[ch - 'a'] == null)
                curr.kids[ch - 'a'] = new TrieNode();
            curr = curr.kids[ch - 'a'];
        }
        curr.isEnd = true;
    }

    static void search(TrieNode root, String str) {
        List<String> temp = new ArrayList<>();
        TrieNode curr = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (curr.kids[ch - 'a'] == null) {
                temp.add("0");
                ans.add(temp);
                return;
            }
            curr = curr.kids[ch - 'a'];
        }
        dfs(curr, temp, "");
        ans.add(temp);
    }

    static void dfs(TrieNode root, List<String> temp, String str) {
        if (root == null) {
            temp.add(str);
            return;
        }
        if (root.isEnd == true)
            temp.add(str);
        for (int i = 0; i < 26; i++) {
            if (root.kids[i] == null)
                continue;

            char ch = (char) (i + 'a');
            dfs(root.kids[i], temp, str + ch);
        }
    }

    static class TrieNode {
        TrieNode kids[] = new TrieNode[26];
        boolean isEnd = false;
    }
}
