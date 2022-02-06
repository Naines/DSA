class WordDictionary {

    /** Initialize your data structure here. */
    class TrieNode {
        TrieNode kids[] = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.kids[ch - 'a'] == null)
                curr.kids[ch - 'a'] = new TrieNode();
            curr = curr.kids[ch - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return search(root, 0, word);
    }

    public boolean search(TrieNode curr, int level, String word) {
        // base case
        if (level == word.length()) {
            return curr.isEnd;
        }
        char ch = word.charAt(level);
        if (ch == '.') {
            for (int i = 0; i < 26; i++)
                if (curr.kids[i] != null && search(curr.kids[i], level + 1, word))
                    return true;
        } else {
            if (curr.kids[ch - 'a'] == null)
                return false;
            return search(curr.kids[ch - 'a'], level + 1, word);
        }
        return false;
    }

}