package Solutions;

import java.util.Arrays;

public class Problem0299 {
    public String getHint(String s,String g) {
        int[] sFreq = new int[10];
        Arrays.fill(sFreq,0);
        for (int i = 0; i < s.length(); ++i) {
            ++sFreq[s.charAt(i) - '0'];
        }
        int t = 0;
        int x = 0;
        for (int i = 0; i < g.length(); ++i) {
            int idx = g.charAt(i) - '0';
            if (sFreq[idx] > 0) {
                --sFreq[g.charAt(i) - '0'];
                ++t;
            }
        }
        for (int i = 0; i < g.length(); ++i) {
            if (g.charAt(i) == s.charAt(i)) {
                ++x;
            }
        }
        return x + "A" + (t - x) + "B";
    }
}
