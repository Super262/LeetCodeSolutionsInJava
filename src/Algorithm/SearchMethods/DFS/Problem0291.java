package Algorithm.SearchMethods.DFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem0291 {
    public boolean wordPatternMatch(String pattern,String s) {
        Map<Character, String> chToWord = new HashMap<>();
        Set<String> usedWords = new HashSet<>();
        return helper(pattern,0,s,0,chToWord,usedWords);
    }

    private boolean helper(String pattern,int patternStart,String str,int strStart,Map<Character, String> chToWord,Set<String> usedWords) {
        if (pattern == null || patternStart == pattern.length()) {
            return strStart == str.length();
        }
        char ch = pattern.charAt(patternStart);
        if (chToWord.containsKey(ch)) {
            String word = chToWord.get(ch);
            if (!str.startsWith(word,strStart)) {
                return false;
            }
            return helper(pattern,patternStart + 1,str,strStart + word.length(),chToWord,usedWords);
        }
        for (int len = 1; strStart + len <= str.length(); ++len) {
            String word = str.substring(strStart,strStart + len);
            if (usedWords.contains(word)) {
                continue;
            }
            usedWords.add(word);
            chToWord.put(ch,word);
            if (helper(pattern,patternStart + 1,str,strStart + word.length(),chToWord,usedWords)) {
                return true;
            }
            usedWords.remove(word);
            chToWord.remove(ch);
        }
        return false;
    }
}
