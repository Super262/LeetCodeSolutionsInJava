package Algorithm.Sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem0347 {
    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        HashMap<Character, Integer> chToFreq = new HashMap<>();
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            chToFreq.put(s.charAt(i),chToFreq.getOrDefault(s.charAt(i),0) + 1);
        }
        ArrayList<ArrayList<Character>> freqToCh = new ArrayList<>(sLen + 1);
        for (int i = 0; i <= sLen; ++i) {
            freqToCh.add(new ArrayList<>());
        }
        StringBuilder strB = new StringBuilder(sLen);
        for (Map.Entry<Character, Integer> entry : chToFreq.entrySet()) {
            freqToCh.get(entry.getValue()).add(entry.getKey());
        }
        for (int f = sLen; f >= 0; f--) {
            for (char ch : freqToCh.get(f)) {
                strB.append(String.valueOf(ch).repeat(f));
            }
        }
        return strB.toString();
    }
}
