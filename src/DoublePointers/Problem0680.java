package DoublePointers;

public class Problem0680 {
    public boolean validPalindrome(String s) {
        if (s == null) {
            return false;
        }
        final int sLen = s.length();
        if (sLen < 2) {
            return true;
        }
        int i = 0;
        int j = sLen - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                ++i;
                --j;
            } else {
                if (i == j - 1) {
                    return true;
                } else {
                    break;
                }
            }
        }
        if (i >= j) {
            return true;
        }
        if (s.charAt(i) == s.charAt(j - 1)) {
            int nI = i;
            int nJ = j - 1;
            while (nI < nJ) {
                if (s.charAt(nI) == s.charAt(nJ)) {
                    ++nI;
                    --nJ;
                } else {
                    break;
                }
            }
            if (nI >= nJ) {
                return true;
            }
        }
        if (s.charAt(i + 1) == s.charAt(j)) {
            int nI = i + 1;
            int nJ = j;
            while (nI < nJ) {
                if (s.charAt(nI) == s.charAt(nJ)) {
                    ++nI;
                    --nJ;
                } else {
                    break;
                }
            }
            return nI >= nJ;
        }
        return false;
    }
}
