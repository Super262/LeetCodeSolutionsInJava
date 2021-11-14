package Solutions;

import java.util.LinkedList;
import java.util.List;

public class Problem0763 {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.isEmpty()) {
            return new LinkedList<>();
        }
        int sLen = S.length();
        int[] chEnd = new int[26];
        for (int i = 0; i < sLen; ++i) {
            chEnd[S.charAt(i) - 'a'] = i;
        }
        LinkedList<Integer> result = new LinkedList<>();
        int i = 0;
        int start = 0;
        int end;
        while (i < sLen) {
            end = chEnd[S.charAt(i) - 'a'];
            ++i;
            while (i <= end) {
                end = Math.max(end,chEnd[S.charAt(i) - 'a']);
                ++i;
            }
            result.addLast(end - start + 1);
            start = end + 1;
        }
        return result;
    }
}
