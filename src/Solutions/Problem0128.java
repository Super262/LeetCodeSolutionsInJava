package Solutions;

import java.util.HashSet;

public class Problem0128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numsPool = new HashSet<>();
        for (int n : nums) {
            numsPool.add(n);
        }
        int maxLen = 0;
        for (int currentN : nums) {
            if (numsPool.contains(currentN - 1)) {
                continue;
            }
            int nextN = currentN + 1;
            while (numsPool.contains(nextN)) {
                nextN++;
            }
            maxLen = Math.max(maxLen,nextN - currentN);
        }
        return maxLen;
    }
}
