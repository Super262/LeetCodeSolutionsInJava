package Algorithm.SearchMethods.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem0127 {
    public int ladderLength(String beginWord,String endWord,List<String> wordList) {
        HashSet<String> wordsDict = new HashSet<>(wordList);
        if (!wordsDict.contains(endWord)) {
            return 0;
        }
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int pathLen = 0;
        int currentSize;
        q.add(beginWord);
        while (!q.isEmpty()) {
            currentSize = q.size();
            ++pathLen;
            for (int i = 0; i < currentSize; ++i) {
                String curNode = q.poll();
                if (endWord.equals(curNode)) {
                    return pathLen;
                }
                for (String candidate : getCandidates(curNode)) {
                    if (visited.contains(candidate) || !wordsDict.contains(candidate)) {
                        continue;
                    }
                    q.add(candidate);
                    visited.add(candidate);
                }
            }
        }
        return 0;
    }

    private List<String> getCandidates(String source) {
        String dict = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder target = new StringBuilder(source);
        List<String> results = new LinkedList<>();
        final int sourceLen = source.length();
        final int dictLen = dict.length();
        for (int si = 0; si < sourceLen; ++si) {
            for (int di = 0; di < dictLen; ++di) {
                if (source.charAt(si) == dict.charAt(di)) {
                    continue;
                }
                target.setCharAt(si,dict.charAt(di));
                results.add(target.toString());
                target.setCharAt(si,source.charAt(si));
            }
        }
        return results;
    }
}
