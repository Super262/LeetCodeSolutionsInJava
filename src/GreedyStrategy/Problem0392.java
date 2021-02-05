package GreedyStrategy;

public class Problem0392 {
    public boolean isSubsequence(String t,String s) {
        if (s == null || t == null) {
            return false;
        }
        final int tLen = t.length();
        if (tLen == 0) {
            return true;
        }
        final int sLen = s.length();
        final char firstCh = t.charAt(0);
        int sStart, tStart;
        for (int i = 0; i < sLen; ++i) {
            if (s.charAt(i) == firstCh) {
                sStart = i;
                tStart = 0;
                while (sStart < sLen && tStart < tLen) {
                    if (s.charAt(sStart) == t.charAt(tStart)) {
                        ++tStart;
                    }
                    ++sStart;
                }
                if (tStart == tLen) {
                    return true;
                }
            }
        }
        return false;
    }
}
