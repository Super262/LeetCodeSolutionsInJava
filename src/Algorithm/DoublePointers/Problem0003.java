package Algorithm.DoublePointers;

import java.util.HashSet;

public class Problem0003 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        final int sLen = s.length();
        if (sLen < 2) {
            return sLen;
        }
        int left = 0;
        int right = 0;
        int maxLen = 0;
        HashSet<Character> existedChars = new HashSet<>();
        while (right < sLen) {
            while (left <= right && existedChars.contains(s.charAt(right))) {
                existedChars.remove(s.charAt(left));
                ++left;
            }
            existedChars.add(s.charAt(right));
            if (maxLen < right - left + 1) {
                maxLen = right - left + 1;
            }
            ++right;
        }
        return maxLen;
    }
}
