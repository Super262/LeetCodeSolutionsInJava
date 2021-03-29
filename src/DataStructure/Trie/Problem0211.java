package DataStructure.Trie;

public class Problem0211 {
    private static class WordDictionary {

        public final WordDictionary[] sons;
        public boolean isWord;
        public String wordVal;

        public WordDictionary() {
            sons = new WordDictionary[26];
            isWord = false;
            wordVal = null;
        }

        public void addWord(String word) {
            WordDictionary p = this;
            final int wordLen = word.length();
            int chOrder;
            for (int i = 0; i < wordLen; ++i) {
                chOrder = word.charAt(i) - 'a';
                if (p.sons[chOrder] == null) {
                    p.sons[chOrder] = new WordDictionary();
                }
                p = p.sons[chOrder];
            }
            p.isWord = true;
            p.wordVal = word;
        }

        public boolean search(String word) {
            return find(word,0,word.length() - 1);
        }

        private boolean find(String word,final int startIndex,final int endIndex) {
            int chOrder;
            if (startIndex == endIndex) {
                if (word.charAt(startIndex) == '.') {
                    for (WordDictionary s : sons) {
                        if (s != null && s.isWord) {
                            return true;
                        }
                    }
                } else {
                    chOrder = word.charAt(startIndex) - 'a';
                    return sons[chOrder] != null && sons[chOrder].isWord;
                }
            } else {
                if (word.charAt(startIndex) == '.') {
                    for (WordDictionary s : sons) {
                        if (s != null && s.find(word,startIndex + 1,endIndex)) {
                            return true;
                        }
                    }
                } else {
                    chOrder = word.charAt(startIndex) - 'a';
                    if (sons[chOrder] == null) {
                        return false;
                    }
                    return sons[chOrder].find(word,startIndex + 1,endIndex);
                }
            }
            return false;
        }
    }
}
