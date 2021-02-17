package Algorithm.DynamicProgramming.KnapsackProblem;

import java.util.List;

public class Problem0139 {
    public boolean wordBreak(String s,List<String> wordDict) {
        if (wordDict.isEmpty()) {
            return false;
        }
        final int sLen = s.length();
        boolean[] dp = new boolean[sLen + 1];
        dp[0] = true;
        int wordLen;
        for (int curLen = 1; curLen <= sLen; ++curLen) {
            for (String word : wordDict) {
                wordLen = word.length();
                if (curLen >= wordLen && s.substring(curLen - wordLen,curLen).equals(word)) {
                    dp[curLen] = dp[curLen] || dp[curLen - wordLen];
                }

            }
        }
        return dp[sLen];
    }
}
