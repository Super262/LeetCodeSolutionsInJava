package Solutions;

import java.util.LinkedList;
import java.util.List;

public class Problem0425 {
    private Node trie;
    private int N;
    private String[] words;

    public List<List<String>> wordSquares(String[] words) {
        if (words == null || words.length == 0) {
            return new LinkedList<>();
        }
        this.words = words;
        N = this.words[0].length();
        buildTrie(this.words,this.N);
        List<List<String>> results = new LinkedList<>();
        for (String word : words) {
            LinkedList<String> temp = new LinkedList<>();
            temp.addLast(word);
            backTracking(1,temp,results);
        }
        return results;
    }

    private void buildTrie(String[] words,final int wordLen) {
        trie = new Node();
        trie.sons = new Node[26];
        trie.wordsIndice = new LinkedList<>();
        Node currentP;
        int chOrder;
        for (int wi = 0; wi < words.length; ++wi) {
            currentP = trie;
            currentP.wordsIndice.add(wi);
            for (int chi = 0; chi < wordLen; ++chi) {
                chOrder = words[wi].charAt(chi) - 'a';
                if (currentP.sons[chOrder] == null) {
                    currentP.sons[chOrder] = new Node();
                }
                currentP = currentP.sons[chOrder];
                if (currentP.wordsIndice == null) {
                    currentP.wordsIndice = new LinkedList<>();
                }
                if (currentP.sons == null) {
                    currentP.sons = new Node[26];
                }
                currentP.wordsIndice.add(wi);
            }
        }
    }

    private void backTracking(final int step,LinkedList<String> temp,List<List<String>> results) {
        if (step == N) {
            LinkedList<String> res = new LinkedList<>(temp);
            results.add(res);
            return;
        }
        StringBuilder prefix = new StringBuilder();
        for (String w : temp) {
            prefix.append(w.charAt(step));
        }
        for (String candidate : getWordsWithThePrefix(prefix)) {
            temp.addLast(candidate);
            backTracking(step + 1,temp,results);
            temp.removeLast();
        }
    }

    private List<String> getWordsWithThePrefix(StringBuilder prefix) {
        int preLen = prefix.length();
        int chOrder;
        Node currentP = trie;
        List<String> result = new LinkedList<>();
        for (int i = 0; i < preLen; ++i) {
            chOrder = prefix.charAt(i) - 'a';
            if (currentP.sons == null || currentP.sons[chOrder] == null) {
                return result;
            }
            currentP = currentP.sons[chOrder];
        }
        if (currentP.wordsIndice != null) {
            for (int i : currentP.wordsIndice) {
                result.add(this.words[i]);
            }
        }
        return result;
    }

    private static class Node {
        Node[] sons;
        List<Integer> wordsIndice;

        Node() {
            sons = null;
            wordsIndice = null;
        }
    }
}
