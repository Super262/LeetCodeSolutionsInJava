package DoublePointers;

import java.util.List;

public class Problem0524 {
    public String findLongestWord(String s,List<String> d) {
        if (s == null || s.isEmpty() || d == null || d.isEmpty()) {
            return "";
        }
        final int sLen = s.length();
        String result = "";
        int resultLen = 0; 
        for (String word : d) {
            int wordLen = word.length();
            int sP = 0;
            int wP = 0;
            while (wP < wordLen) {
                while (sP < sLen && s.charAt(sP) != word.charAt(wP)) {
                    ++sP;
                }
                if (sP >= sLen) {
                    break;
                } else {
                    ++sP;
                }
                ++wP;
            }
            if (wP >= wordLen) {
                if (wordLen > resultLen) {
                    result = word;
                    resultLen = wordLen;
                } else if (resultLen == wordLen) {
                    if (word.compareTo(result) < 0) {
                        result = word;
                    }
                }
            }
        }
        return result;
    }
}
