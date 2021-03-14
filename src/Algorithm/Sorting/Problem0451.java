package Algorithm.Sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem0451 {
    public String frequencySort(String s) {
        if (s == null) {
            return null;
        }
        int sLen = s.length();
        if (sLen == 0) {
            return "";
        }
        HashMap<Character, Integer> chFreq = new HashMap<>();
        for (int i = 0; i < sLen; ++i) {
            chFreq.put(s.charAt(i),chFreq.getOrDefault(s.charAt(i),0) + 1);
        }
        ArrayList<ArrayList<Character>> frequencyBucket = new ArrayList<>(sLen + 1);
        for (int i = 0; i <= sLen; ++i) {
            frequencyBucket.add(new ArrayList<>());
        }
        for (Map.Entry<Character, Integer> entry : chFreq.entrySet()) {
            frequencyBucket.get(entry.getValue()).add(entry.getKey());
        }
        StringBuilder result = new StringBuilder(sLen);
        for (int i = sLen; i >= 0; --i) {
            if (!frequencyBucket.get(i).isEmpty()) {
                for (Character ch : frequencyBucket.get(i)) {
                    for (int j = 0; j < i; ++j) {
                        result.append(ch);
                    }
                }
            }
        }
        return result.toString();
    }
}
