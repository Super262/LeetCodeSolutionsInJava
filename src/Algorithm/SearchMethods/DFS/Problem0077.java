package Algorithm.SearchMethods.DFS;

import java.util.LinkedList;
import java.util.List;

public class Problem0077 {
    public List<List<Integer>> combine(int n,int k) {
        return getCombinations(n,k,1);
    }

    private List<List<Integer>> getCombinations(final int n,final int k,final int start) {
        List<List<Integer>> result = new LinkedList<>();
        if (k != 0) {
            for (int i = start; i < n - k + 2; ++i) {
                List<List<Integer>> postPart = getCombinations(n,k - 1,i + 1);
                if (!postPart.isEmpty()) {
                    for (List<Integer> l : postPart) {
                        l.add(0,i);
                        result.add(l);
                    }
                } else {
                    List<Integer> temp = new LinkedList<>();
                    temp.add(i);
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
