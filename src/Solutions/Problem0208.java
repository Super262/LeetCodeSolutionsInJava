package Solutions;

public class Problem0208 {
    private static class Trie {
        public final Trie[] sons;
        public boolean isWord;
        public String wordVal;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            sons = new Trie[26];
            wordVal = null;
            isWord = false;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            final int wordLen = word.length();
            int chOrder;
            Trie p = this;
            for (int i = 0; i < wordLen; ++i) {
                chOrder = word.charAt(i) - 'a';
                if (p.sons[chOrder] == null) {
                    p.sons[chOrder] = new Trie();
                }
                p = p.sons[chOrder];
            }
            p.isWord = true;
            p.wordVal = word;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            final int wordLen = word.length();
            int chOrder;
            Trie p = this;
            for (int i = 0; i < wordLen; ++i) {
                chOrder = word.charAt(i) - 'a';
                if (p.sons[chOrder] == null) {
                    return false;
                }
                p = p.sons[chOrder];
            }
            return p.isWord && word.equals(p.wordVal);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            final int wordLen = prefix.length();
            int chOrder;
            Trie p = this;
            for (int i = 0; i < wordLen; ++i) {
                chOrder = prefix.charAt(i) - 'a';
                if (p.sons[chOrder] == null) {
                    return false;
                }
                p = p.sons[chOrder];
            }
            return true;
        }
    }
}
