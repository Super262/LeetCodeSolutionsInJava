package Algorithm.SearchMethods.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem0127 {
    public int ladderLength(String beginWord,String endWord,List<String> wordList) {
        wordList.add(beginWord);
        final int beginWordIndex = wordList.indexOf(beginWord);
        final int endWordIndex = wordList.indexOf(endWord);
        ArrayList<LinkedList<Integer>> wordsMap = buildWordsMap(wordList);
        boolean[] visited = new boolean[wordList.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(beginWordIndex);
        int pathLength = 0;
        int levelSize;
        int currentWordIndex;
        while (!q.isEmpty()) {
            ++pathLength;
            levelSize = q.size();
            while (levelSize > 0) {
                currentWordIndex = q.poll();
                --levelSize;
                visited[currentWordIndex] = true;
                if (currentWordIndex == endWordIndex) {
                    return pathLength;
                } else {
                    if (wordsMap.size() > currentWordIndex) {
                        for (Integer w : wordsMap.get(currentWordIndex)) {
                            if (!visited[w]) {
                                q.add(w);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    private ArrayList<LinkedList<Integer>> buildWordsMap(List<String> wordList) {
        final int listSize = wordList.size();
        ArrayList<LinkedList<Integer>> wordsMap = new ArrayList<>(listSize);
        for (int i = 0; i < listSize; ++i) {
            wordsMap.add(new LinkedList<>());
        }
        int i = 0;
        int j;
        for (String a : wordList) {
            j = 0;
            for (String b : wordList) {
                if (isConnected(a,b)) {
                    wordsMap.get(i).addLast(j);
                }
                ++j;
            }
            ++i;
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
