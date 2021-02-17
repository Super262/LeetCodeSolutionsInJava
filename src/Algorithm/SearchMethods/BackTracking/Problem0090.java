package Algorithm.SearchMethods.BackTracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Problem0090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i <= nums.length; ++i) {
            result.addAll(getCombinations(nums,0,i));
        }
        return result;
    }

    private List<List<Integer>> getCombinations(int[] nums,int start,int targetLength) {
        List<List<Integer>> result = new LinkedList<>();
        if (targetLength < 0 || targetLength > nums.length - start) {
            return result;
        } else if (targetLength == 0) {
            LinkedList<Integer> tempResult = new LinkedList<>();
            result.add(tempResult);
        } else if (targetLength == nums.length - start) {
            LinkedList<Integer> tempResult = new LinkedList<>();
            for (int i = start; i < nums.length; ++i) {
                tempResult.addLast(nums[i]);
            }
            result.add(tempResult);
        } else {
            HashSet<Integer> visited = new HashSet<>();
            if (targetLength == 1) {
                for (int i = start; i < nums.length; ++i) {
                    if (!visited.contains(nums[i])) {
                        visited.add(nums[i]);
                        LinkedList<Integer> tempResult = new LinkedList<>();
                        tempResult.addLast(nums[i]);
                        result.add(tempResult);
                    }
                }
            } else {
                for (int i = start; i < nums.length; ++i) {
                    if (!visited.contains(nums[i])) {
                        visited.add(nums[i]);
                        List<List<Integer>> postPart = getCombinations(nums,i + 1,targetLength - 1);
                        for (List<Integer> l : postPart) {
                            l.add(0,nums[i]);
                        }
                        result.addAll(postPart);
                    }
                }
            }
        }
        return result;
    }
}
