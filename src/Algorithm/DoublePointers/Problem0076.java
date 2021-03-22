package Algorithm.DoublePointers;

public class Problem0076 {
    public String minWindow(String s,String t) {
        if (s == null || t == null) {
            return "";
        }
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0) {
            return "";
        }
        int[] countT = new int[256];
        int uniqueT = 0;
        for (int i = 0; i < tLen; ++i) {
            ++countT[t.charAt(i)];
            if (countT[t.charAt(i)] == 1) {
                ++uniqueT;
            }
        }
        int[] countS = new int[256];
        int uniqueS = 0;
        int left = 0;
        int right = 0;
        int ansL = -1;
        int ansR = -1;
        while (left < sLen) {
            while (right < sLen && uniqueS < uniqueT) {
                ++countS[s.charAt(right)];
                if (countS[s.charAt(right)] == countT[s.charAt(right)]) {
                    ++uniqueS;
                }
                ++right;
            }
            if (uniqueS == uniqueT) {
                if (ansL == -1 || right - left < ansR - ansL) {
                    ansL = left;
                    ansR = right;
                }
            }
            --countS[s.charAt(left)];
            if (countS[s.charAt(left)] == countT[s.charAt(left)] - 1) {
                --uniqueS;
            }
            ++left;
        }
        if (ansL == -1) {
            return "";
        }
        return s.substring(ansL,ansR);
    }
}
