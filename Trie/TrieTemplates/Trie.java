package TrieTemplates;

class Trie {
    /** Initialize your data structure here. */
    Trie kids[];
    boolean isEnd;

    public Trie() {
        kids = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.kids[index] == null)
                curr.kids[index] = new Trie();
            curr = curr.kids[index];
        }
        curr.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.kids[index] == null)
                return false;
            curr = curr.kids[index];
        }
        return curr.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie curr = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (curr.kids[index] == null)
                return false;
            curr = curr.kids[index];
        }
        return true;
    }
}
