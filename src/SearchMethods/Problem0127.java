package SearchMethods;

import java.util.*;

public class Problem0127 {
    public int ladderLength(String beginWord,String endWord,List<String> wordList) {
        wordList.add(beginWord);
        final int maxLen = wordList.size();
        HashMap<String, HashSet<String>> wordsMap = buildWordsMap(wordList);
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int pathLength = 0;
        int levelSize;
        String currentWord;
        HashSet<String> adjWords;
        while (!q.isEmpty()) {
            ++pathLength;
            levelSize = q.size();
            while (levelSize > 0) {
                currentWord = q.poll();
                --levelSize;
                visited.add(currentWord);
                if (currentWord.equals(endWord)) {
                    return pathLength;
                } else {
                    if (wordsMap.containsKey(currentWord)) {
                        adjWords = wordsMap.get(currentWord);
                        for (String w : adjWords) {
                            if (!visited.contains(w)) {
                                q.add(w);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    private HashMap<String, HashSet<String>> buildWordsMap(List<String> wordList) {
        HashMap<String, HashSet<String>> wordsMap = new HashMap<>();
        for (String a : wordList) {
            for (String b : wordList) {
                if (isConnected(a,b)) {
                    if (wordsMap.containsKey(a)) {
                        wordsMap.get(a).add(b);
                    } else {
                        HashSet<String> nodeSet = new HashSet<>();
                        nodeSet.add(b);
                        wordsMap.put(a,nodeSet);
                    }
                }
            }
        }
        return wordsMap;
    }

    private boolean isConnected(String a,String b) {
        final int wordLen = a.length();
        if (a.equals(b) || wordLen != b.length()) {
            return false;
        }
        int diffCount = 0;
        for (int i = 0; i < wordLen; ++i) {
            diffCount += a.charAt(i) == b.charAt(i) ? 0 : 1;
        }
        return diffCount == 1;
    }
}
