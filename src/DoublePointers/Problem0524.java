package DoublePointers;

import java.util.List;

public class Problem0524 {
    public String findLongestWord(String s,List<String> d) {
        if (s == null || s.isEmpty() || d == null || d.isEmpty()) {
            return "";
        }
        String result = "";
        int resultLen = 0;
        int temp;
        for (String w : d) {
            temp = isSubStr(s,w);
            if (temp != -1) {
                if (temp > resultLen || (temp == resultLen && w.compareTo(result) < 0)) {
                    result = w;
                    resultLen = temp;
                }
            }
        }
        return result;
    }

    private int isSubStr(String s,String w) {
        int wLen = w.length();
        int sLen = s.length();
        int sP = 0;
        int wP = 0;
        while (sP < sLen && wP < wLen) {
            if (s.charAt(sP) == w.charAt(wP)) {
                ++wP;
            }
            ++sP;
        }
        if (wP >= wLen) {
            return wLen;
        } else {
            return -1;
        }
    }
}
