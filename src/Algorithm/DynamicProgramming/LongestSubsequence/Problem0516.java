package Algorithm.DynamicProgramming.LongestSubsequence;

public class Problem0516 {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        final int sLen = s.length();
        int[][] seqLen = new int[sLen][sLen];
        for (int start = 0; start < sLen; ++start) {
            seqLen[start][start] = 1;
        }
        for (int start = sLen - 1; start >= 0; --start) {
            for (int end = start + 1; end < sLen; ++end) {
                if (s.charAt(end) == s.charAt(start)) {
                    seqLen[start][end] = seqLen[start + 1][end - 1] + 2;
                } else {
                    seqLen[start][end] = Math.max(seqLen[start + 1][end],seqLen[start][end - 1]);
                }
            }
        }
        return seqLen[0][sLen - 1];
    }
}
