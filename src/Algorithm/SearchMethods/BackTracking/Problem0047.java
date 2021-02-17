package Algorithm.SearchMethods.BackTracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Problem0047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new LinkedList<>();
        } else {
            return getResult(nums,0,nums.length - 1);
        }
    }

    private List<List<Integer>> getResult(int[] nums,int start,int end) {
        List<List<Integer>> result = new LinkedList<>();
        if (start > end) {
            return result;
        } else if (start == end) {
            LinkedList<Integer> l = new LinkedList<>();
            l.add(nums[start]);
            result.add(l);
        } else {
            HashSet<Integer> visited = new HashSet<>();
            for (int i = start; i <= end; ++i) {
                if (!visited.contains(nums[i])) {
                    visited.add(nums[i]);
                    swap(nums,i,start);
                    List<List<Integer>> part = getResult(nums,start + 1,end);
                    swap(nums,i,start);
                    for (List<Integer> l : part) {
                        l.add(0,nums[i]);
                        result.add(l);
                    }
                }
            }
        }

        return result;
    }

    private void swap(int[] nums,int a,int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
