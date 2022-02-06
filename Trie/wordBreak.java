public class wordBreak {
    static class Node {
        Node kids[] = new Node[26];
        boolean isEnd = false;
    }

    /**
     * Input: ilike Output: Yes The string can be segmented as "i like".
     * 
     * Input: ilikesamsung Output: Yes The string can be segmented as "i like
     * samsung" or "i like sam sung".
     * 
     * @param args
     */

    public static void main(String[] args) {
        Node root = new Node();
        String words[] = { "mobile", "samsung", "sam", "sung", "ma", "mango", "icecream", "and", "go", "i", "like",
                "ice", "cream" };
        for (String s : words) {
            add(root, s);
        }
        System.out.print(wordbreak("ilikesamsung", root) ? "Yes\n" : "No\n");
        System.out.print(wordbreak("iiiiiiii", root) ? "Yes\n" : "No\n");
        System.out.print(wordbreak("", root) ? "Yes\n" : "No\n");
        System.out.print(wordbreak("ilikelikeimangoiii", root) ? "Yes\n" : "No\n");
        System.out.print(wordbreak("samsungandmango", root) ? "Yes\n" : "No\n");
        System.out.print(wordbreak("samsungandmangok", root) ? "Yes\n" : "No\n");

    }

    static void add(Node root, String key) {
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (curr.kids[ch - 'a'] == null)
                curr.kids[ch - 'a'] = new Node();
            curr = curr.kids[ch - 'a'];
        }
        curr.isEnd = true;
    }

    static boolean search(Node root, String key) {
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (curr.kids[ch - 'a'] == null)
                return false;
            curr = curr.kids[ch - 'a'];
        }
        return curr.isEnd;
    }

    static boolean wordbreak(String key, Node root) {
        int size = key.length();
        if (size == 0)
            return true;

        for (int i = 1; i <= size; i++) {
            // We first check whether
            // current prefix is in dictionary.
            // Then we recursively check for remaining
            // string str.substr(i, size) which
            // is suffix of length size-i.
            if (search(root, key.substring(0, i)) && wordbreak(key.substring(i, size), root))
                return true;
        }
        return false;
    }
}
