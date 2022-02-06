public class SmallestPrefix {
    static class trieNode {
        trieNode kids[] = new trieNode[26];
        int freq = 0;

        trieNode() {
        }

    }

    public static void main(String[] args) {

        /**
         * Input: arr[] = {"geeksgeeks", "geeksquiz", "geeksforgeeks"}; Output: geeksf,
         * geeksg, geeksq}
         */
        // String str[] = { "duck", "dog", "dove", "zebra" };
        String str[] = { "geeksgeeks", "geeksquiz", "geeksforgeeks" };
        trieNode root = new trieNode();
        for (String s : str) {
            add(root, s);
        }
        // System.out.println(root.kids['d' - 'a'].kids['o' - 'a'].kids['g' -
        // 'a'].freq);
        for (String s : str) {
            System.out.println(search(root, s, "", 0));
        }
        // dfs(root, "");
    }

    static void add(trieNode root, String s) {
        trieNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (curr.kids[ch - 'a'] == null) {
                curr.kids[ch - 'a'] = new trieNode();
                curr.kids[ch - 'a'].freq++;
            } else
                curr.kids[ch - 'a'].freq++;

            curr = curr.kids[ch - 'a'];
        }
    }

    static String search(trieNode curr, String str, String ans, int i) {
        if (curr == null)
            return "";
        if (curr.freq == 1)
            return "";

        char ch = str.charAt(i);
        curr = curr.kids[ch - 'a'];
        return ch + search(curr, str, ans, i + 1);
    }
}
