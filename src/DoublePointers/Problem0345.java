package DoublePointers;

import java.util.Arrays;
import java.util.HashSet;

public class Problem0345 {
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        final int sLen = s.length();
        if (sLen < 1) {
            return s;
        }
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        char[] tempStr = s.toCharArray();
        int i = 0;
        int j = sLen - 1;
        char tempCh;
        while (i < j) {
            while (i < j && !vowels.contains(tempStr[i])) {
                ++i;
            }
            while (j > i && !vowels.contains(tempStr[j])) {
                --j;
            }
            if (i < j) {
                tempCh = tempStr[i];
                tempStr[i] = tempStr[j];
                tempStr[j] = tempCh;
                ++i;
                --j;
            }
        }
        return new String(tempStr);
    }
}
