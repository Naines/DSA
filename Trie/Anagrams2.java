import java.util.Arrays;
import java.util.LinkedList;

public class Anagrams2 {
    static class TrieNode {
        boolean isEnd;
        TrieNode[] child = new TrieNode[26];
        LinkedList<Integer> head = new LinkedList<>();
    }

    public static void main(String args[]) {
        String wordArr[] = { "cat", "dog", "tac", "god", "act", "gdo" };
        int size = wordArr.length;
        printAnagramsTogether(wordArr, size);
    }

    static void printAnagramsTogether(String wordArr[], int size) {
        TrieNode root = null;
        for (int i = 0; i < size; i++) {
            char[] chs = wordArr[i].toCharArray();
            Arrays.sort(chs);
            root = insert(root, new String(chs), i, 0);

        }
        printAnagramsUtil(root, wordArr);
    }

    static TrieNode insert(TrieNode root, String word, int index, int i) {
        if (root == null) {
            root = new TrieNode();
        }

        if (i < word.length()) {
            int index1 = word.charAt(i) - 'a';
            root.child[index1] = insert(root.child[index1], word, index, i + 1);
        } else {
            root.isEnd = true;
            root.head.add(index);
        }
        return root;
    }

    static void printAnagramsUtil(TrieNode root, String wordArr[]) {
        if (root == null)
            return;
        if (root.isEnd == true) {
            for (int i : root.head)
                System.out.println(wordArr[i]);
        }

        for (int i = 0; i < 26; ++i)
            printAnagramsUtil(root.child[i], wordArr);
    }

}
