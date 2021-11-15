package Solutions;

import java.util.HashMap;
import java.util.Map;

public class Problem0242 {
    public boolean isAnagram(String s,String t) {
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0) + 1);
        }
        for (int i = 0; i < t.length(); ++i) {
            tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0) + 1);
        }
        for (Map.Entry<Character, Integer> item : tmap.entrySet()) {
            if (!smap.containsKey(item.getKey()) || !smap.get(item.getKey()).equals(item.getValue())) {
                return false;
            }
        }
        for (Map.Entry<Character, Integer> item : smap.entrySet()) {
            if (!tmap.containsKey(item.getKey()) || !tmap.get(item.getKey()).equals(item.getValue())) {
                return false;
            }
        }
        return true;
    }
}
