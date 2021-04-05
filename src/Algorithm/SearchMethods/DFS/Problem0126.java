package Algorithm.SearchMethods.DFS;

import java.util.*;

public class Problem0126 {
    public List<List<String>> findLadders(String beginWord,String endWord,List<String> wordList) {
        HashSet<String> wordDict = new HashSet<>(wordList);
        if (!wordDict.contains(endWord)) {
            return new LinkedList<>();
        }
        wordDict.add(beginWord);
        Map<String, Set<String>> indices = buildIndices(wordDict);
        Map<String, Integer> distance = bfsToGetDistanceFromEnd(endWord,indices,wordDict);
        List<List<String>> results = new LinkedList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfsToGetPathFromStart(beginWord,endWord,distance,indices,path,results);
        return results;
    }

    private void dfsToGetPathFromStart(String current,String target,Map<String, Integer> distance,Map<String, Set<String>> indices,List<String> path,List<List<String>> results) {
        if (target.equals(current)) {
            results.add(new ArrayList<>(path));
            return;
        }
        for (String neighbor : getNeighbors(current,indices)) {
            if (distance.get(neighbor) != distance.get(current) - 1) {
                continue;
            }
            path.add(neighbor);
            dfsToGetPathFromStart(neighbor,target,distance,indices,path,results);
            path.remove(path.size() - 1);
        }
    }

    private Map<String, Integer> bfsToGetDistanceFromEnd(String end,Map<String, Set<String>> indices,Set<String> wordDict) {
        Map<String, Integer> distance = new HashMap<>();
        distance.put(end,0);
        Queue<String> queue = new LinkedList<>();
        queue.offer(end);
        while (!queue.isEmpty()) {
            end = queue.poll();
            for (String neighbor : getNeighbors(end,indices)) {
                if (distance.containsKey(neighbor)) {
                    continue;
                }
                distance.put(neighbor,distance.get(end) + 1);
                queue.offer(neighbor);
            }
        }
        for (String word : wordDict) {
            if (distance.containsKey(word)) {
                continue;
            }
            distance.put(word,Integer.MAX_VALUE);
        }
        return distance;
    }

    private Map<String, Set<String>> buildIndices(Set<String> wordDict) {
        Map<String, Set<String>> indices = new HashMap<>();
        for (String w : wordDict) {
            for (int i = 0; i < w.length(); ++i) {
                String key = w.substring(0,i) + "%" + w.substring(i + 1);
                if (!indices.containsKey(key)) {
                    indices.put(key,new HashSet<>());
                }
                indices.get(key).add(w);
            }
        }
        return indices;
    }

    private List<String> getNeighbors(String word,Map<String, Set<String>> indices) {
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < word.length(); ++i) {
            String key = word.substring(0,i) + "%" + word.substring(i + 1);
            neighbors.addAll(indices.get(key));
        }
        return neighbors;
    }
}
