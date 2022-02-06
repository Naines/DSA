/**
 * TrieNode
 */
public class TrieBasic {

    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        String str[] = { "bat", "bag", "gun", "guns", "zoo" };
        for (String s : str) {
            root.add(root, s);
        }

        System.out.println(root.search(root, "bag"));
        System.out.println(root.search(root, "bat"));
        System.out.println(root.search(root, "ban"));
        System.out.println(root.search(root, "zoo"));
        System.out.println(root.search(root, "gun"));

        // delete
        // root.delete(root, "bat", 0);
        // root.delete(root, "gun", 0);

        System.out.println(root.search(root, "gun"));

        root.dfs(root, "");
    }

    static class TrieNode {
        final int size = 26;
        TrieNode kids[];
        boolean isEnd;

        TrieNode() {
            this.kids = new TrieNode[size];
            this.isEnd = false;
        }

        void add(TrieNode root, String key) {

            TrieNode curr = root;
            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a';
                if (curr.kids[index] == null)
                    curr.kids[index] = new TrieNode();
                curr = curr.kids[index];
            }
            curr.isEnd = true;
        }

        boolean search(TrieNode root, String key) {
            TrieNode curr = root;
            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a';
                if (curr.kids[index] == null)
                    return false;
                curr = curr.kids[index];
            }
            return curr.isEnd;
        }

        TrieNode delete(TrieNode root, String key, int i) {

            // base case: when tree becomes empty
            if (root == null)
                return null;

            // self work
            if (i == key.length()) {

                // word found
                if (root.isEnd == true)
                    root.isEnd = false;
                // if subsequent nodes present
                if (isEmpty(root))
                    root = null;

                return root;
            }

            // recusrive line
            int index = key.charAt(i) - 'a';
            root.kids[index] = delete(root.kids[index], key, i + 1);

            // if root dont have any child and not the end of other word
            if (isEmpty(root) && root.isEnd == false)
                root = null;

            return root;

        }

        void dfs(TrieNode root, String str) {
            if (root == null) {
                System.out.println(str);
                return;
            }
            if (root.isEnd == true)
                System.out.println(str);
            for (int i = 0; i < 26; i++) {
                if (root.kids[i] == null)
                    continue;

                char ch = (char) (i + 'a');
                dfs(root.kids[i], str + ch);
            }
        }

        boolean isEmpty(TrieNode root) {
            for (int i = 0; i < size; i++)
                if (root.kids[i] != null)
                    return false;
            return true;
        }
    }
}