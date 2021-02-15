package Sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem0347 {
    public int[] topKFrequent(int[] nums,int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> numToFreq = new HashMap<>();
        for (int num : nums) {
            numToFreq.put(num,numToFreq.getOrDefault(num,0) + 1);
        }
        ArrayList<ArrayList<Integer>> freqToNum = new ArrayList<>(nums.length + 1);
        for (int i = 0; i <= nums.length; ++i) {
            freqToNum.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : numToFreq.entrySet()) {
            freqToNum.get(entry.getValue()).add(entry.getKey());
        }
        int resultTop = 0;
        int i;
        for (int f = nums.length; f >= 0; --f) {
            if (resultTop < result.length) {
                i = 0;
                while (resultTop < nums.length && i < freqToNum.get(f).size()) {
                    result[resultTop++] = freqToNum.get(f).get(i++);
                }
            } else {
                break;
            }
        }
        return result;
    }
}
