package Algorithm.SearchMethods.BFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Problem0269 {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        if (words.length == 1) {
            return words[0];
        }
        HashMap<Character, Integer> inDegree = new HashMap<>();
        HashMap<Character, HashSet<Character>> neighbors = new HashMap<>();
        for (String w : words) {
            for (int i = 0; i < w.length(); ++i) {
                if (!inDegree.containsKey(w.charAt(i))) {
                    inDegree.put(w.charAt(i),0);
                }
                if (!neighbors.containsKey(w.charAt(i))) {
                    neighbors.put(w.charAt(i),new HashSet<>());
                }
            }
        }
        for (int i = 1; i < words.length; ++i) {
            int varianceIndex = getVarianceIndex(words[i - 1],words[i]);
            if (varianceIndex == -1) {
                if (words[i - 1].length() > words[i].length()) {
                    return "";
                }
                continue;
            }
            if (!neighbors.get(words[i - 1].charAt(varianceIndex)).contains(words[i].charAt(varianceIndex))) {
                neighbors.get(words[i - 1].charAt(varianceIndex)).add(words[i].charAt(varianceIndex));
                inDegree.put(words[i].charAt(varianceIndex),inDegree.get(words[i].charAt(varianceIndex)) + 1);
            }
        }
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for (Character ch : inDegree.keySet()) {
            if (inDegree.get(ch) == 0) {
                pq.add(ch);
            }
        }
        StringBuilder result = new StringBuilder(inDegree.size());
        Character node;
        while (!pq.isEmpty()) {
            node = pq.poll();
            result.append(node);
            for (Character n : neighbors.get(node)) {
                inDegree.put(n,inDegree.get(n) - 1);
                if (inDegree.get(n) == 0) {
                    pq.add(n);
                }
            }
        }
        if (result.length() == inDegree.size()) {
            return result.toString();
        }
        return "";
    }

    private Integer getVarianceIndex(String s1,String s2) {
        if (s1 == null || s2 == null) {
            return -1;
        }
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return i;
            }
            ++i;
        }
        return -1;
    }
}
