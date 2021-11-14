package Solutions;

public class Problem0340 {
    public int lengthOfLongestSubstringKDistinct(String s,int k) {
        if (s == null || k <= 0) {
            return 0;
        }
        int sLen = s.length();
        if (sLen == 0) {
            return 0;
        }
        int[] chFreq = new int[256];
        int uniqueCount = 0;
        int result = 0;
        int left = 0;
        int right = 0;
        while (right < sLen) {
            ++chFreq[s.charAt(right)];
            if (chFreq[s.charAt(right)] == 1) {
                ++uniqueCount;
            }
            ++right;
            while (left < right && uniqueCount > k) {
                --chFreq[s.charAt(left)];
                if (chFreq[s.charAt(left)] == 0) {
                    --uniqueCount;
                }
                ++left;
            }
            if (result < right - left) {
                result = right - left;
            }
        }
        return result;
    }
}
