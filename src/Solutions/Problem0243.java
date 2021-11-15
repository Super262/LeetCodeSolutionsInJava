package Solutions;

public class Problem0243 {
    public int shortestDistance(String[] dict,String w1,String w2) {
        int s1 = -1;
        int s2 = -1;
        int result = dict.length;
        for (int i = 0; i < dict.length; ++i) {
            if (dict[i].equals(w1)) {
                s1 = i;
            } else if (dict[i].equals(w2)) {
                s2 = i;
            }
            if (s1 == -1 || s2 == -1) {
                continue;
            }
            result = Math.min(result,Math.abs(s1 - s2));
        }
        return result;
    }
}
