package Algorithm.SearchMethods.BFS;

import java.util.ArrayList;
import java.util.List;

public class Problem0078 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> queue = new ArrayList<>((int) Math.pow(2,nums.length));
        queue.add(new ArrayList<>());
        int index = 0;
        while (index < queue.size()) {
            List<Integer> baseSet = queue.get(index);
            for (int num : nums) {
                if (!baseSet.isEmpty() && baseSet.get(baseSet.size() - 1) >= num) {
                    continue;
                }
                List<Integer> tmp = new ArrayList<>(baseSet);
                tmp.add(num);
                queue.add(tmp);
            }
            ++index;
        }
        return queue;
    }
}
