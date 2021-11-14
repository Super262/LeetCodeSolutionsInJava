package Solutions;

import java.util.Arrays;

public class Problem0455 {
    public int findContentChildren(int[] g,int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gP = 0;
        int sP = 0;
        while (gP < g.length && sP < s.length) {
            if (g[gP] <= s[sP]) {
                ++sP;
                ++gP;
            } else {
                ++sP;
            }
        }
        return gP;
    }
}
