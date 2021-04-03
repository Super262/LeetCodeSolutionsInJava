package Algorithm.SearchMethods.DFS;

import java.util.LinkedList;
import java.util.List;

public class Problem0216 {
    public List<List<Integer>> combinationSum3(int k,int n) {
        return getCombinations(k,n,1);
    }

    private List<List<Integer>> getCombinations(final int targetLength,final int targetSum,final int start) {
        List<List<Integer>> result = new LinkedList<>();
        final int maxNum = 10;
        if (targetLength < 1) {
            return result;
        } else if (targetLength == 1) {
            for (int i = start; i < maxNum; ++i) {
                if (i == targetSum) {
                    LinkedList<Integer> tempList = new LinkedList<>();
                    tempList.add(i);
                    result.add(tempList);
                    return result;
                }
            }
        } else {
            final int preStartMax = maxNum - targetLength;
            for (int i = start; i <= preStartMax; ++i) {
                List<List<Integer>> tempResult = getCombinations(targetLength - 1,targetSum - i,i + 1);
                for (List<Integer> l : tempResult) {
                    l.add(0,i);
                    result.add(l);
                }
            }
        }
        return result;
    }
}
