package Tries;

class Trie {

    Trie[] children;
    boolean eow; // End of word flag

    public Trie() {
        this.children = new Trie[26]; // Initialize children array for 26 letters
        this.eow = false; // Initialize end of word flag
    }

    public void insert(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Trie();
            }
            curr = curr.children[idx];
        }
        curr.eow = true; // Mark end of the inserted word
    }

    public boolean search(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false; // Word not found
            }
            curr = curr.children[idx];
        }
        return curr.eow; // Check if we reached end of a valid word
    }

    public boolean startsWith(String prefix) {
        Trie curr = this;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false; // Prefix not found
            }
            curr = curr.children[idx];
        }
        return true; // Prefix found
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

