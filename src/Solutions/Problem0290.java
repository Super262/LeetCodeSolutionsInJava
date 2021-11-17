package Solutions;

import java.util.HashMap;
import java.util.Map;

public class Problem0290 {
    public boolean wordPattern(String pattern,String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<String, Character> wp = new HashMap<>();
        Map<Character, String> pw = new HashMap<>();
        for (int i = 0; i < pattern.length(); ++i) {
            if (pw.containsKey(pattern.charAt(i)) && !words[i].equals(pw.get(pattern.charAt(i)))) {
                return false;
            }
            pw.put(pattern.charAt(i),words[i]);
            if (wp.containsKey(words[i]) && pattern.charAt(i) != wp.get(words[i])) {
                return false;
            }
            wp.put(words[i],pattern.charAt(i));
        }
        return true;
    }
}
