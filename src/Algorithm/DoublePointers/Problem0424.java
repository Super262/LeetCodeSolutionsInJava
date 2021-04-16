package Algorithm.DoublePointers;

public class Problem0424 {
    public int characterReplacement(String s,int k) {
        if (s == null) {
            return 0;
        }
        final int sLen = s.length();
        if (sLen <= k) {
            return sLen;
        }
        int[] counter = new int[26];
        int right = 0;
        int answer = 0;
        int maxFreq = 0;
        for (int left = 0; left < sLen; ++left) {
            right = Math.max(right,left);
            // 选择"小于或等于k"作为边界条件，可以得到尽可能长（right-left）的子串
            while (right < sLen && right - left - maxFreq <= k) {
                ++counter[s.charAt(right) - 'A'];
                maxFreq = Math.max(counter[s.charAt(right) - 'A'],maxFreq);
                ++right;
            }
            if (right - left - maxFreq > k) {
                answer = Math.max(answer,right - left - 1);
            } else {
                answer = Math.max(answer,right - left);
            }
            --counter[s.charAt(left) - 'A'];
            maxFreq = getMaxValue(counter);
        }
        return answer;
    }

    private int getMaxValue(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int v : nums) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }
}
