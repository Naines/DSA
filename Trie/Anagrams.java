import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Anagrams {
    public static void main(String[] args) {
        // List<List<String>> ans = new ArrayList<>();

        String words[] = { "dog", "cat", "atc", "tac", "god" };

        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            char ch[] = words[i].toCharArray();
            Arrays.sort(ch);
            String temp = new String(ch);
            add(root, temp, i);
        }

        print_dfs(root, words);

    }

    static void add(TrieNode root, String key, int index) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (curr.kids[ch - 'a'] == null)
                curr.kids[ch - 'a'] = new TrieNode();
            curr = curr.kids[ch - 'a'];
        }
        curr.isEnd = true;
        curr.list.add(index);
    }

    static void print_dfs(TrieNode root, String words[]) {
        // find all lists

        if (root == null)
            return;

        if (root.isEnd == true) {
            for (int i : root.list)
                System.out.println(words[i]);
        }
        for (int i = 0; i < 26; i++) {
            print_dfs(root.kids[i], words);
        }

    }

    static class TrieNode {
        TrieNode kids[] = new TrieNode[26];
        boolean isEnd;
        List<Integer> list = new LinkedList<>();
    }
}
