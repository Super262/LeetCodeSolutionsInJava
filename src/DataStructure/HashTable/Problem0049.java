package DataStructure.HashTable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> wordDict = new HashMap<>();
        for (String s : strs) {
            String sortedStr = countAndSort(s);
            List<String> currentGroup = wordDict.getOrDefault(sortedStr,null);
            if (currentGroup == null) {
                currentGroup = new LinkedList<>();
                wordDict.put(sortedStr,currentGroup);
            }
            currentGroup.add(s);
        }
        List<List<String>> results = new LinkedList<>();
        for (Map.Entry<String, List<String>> entry : wordDict.entrySet()) {
            results.add(entry.getValue());
        }
        return results;
    }

    private String countAndSort(String s) {
        int[] chTable = new int[26];
        StringBuilder result = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); ++i) {
            chTable[s.charAt(i) - 'a']++;
        }
        for (int offset = 0; offset < chTable.length; ++offset) {
            for (int i = 0; i < chTable[offset]; ++i) {
                result.append((char) ('a' + offset));
            }
        }
        return result.toString();
    }
}
