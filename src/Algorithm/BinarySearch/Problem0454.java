package Algorithm.BinarySearch;

import java.util.HashMap;

public class Problem0454 {
    public int fourSumCount(int[] A,int[] B,int[] C,int[] D) {
        int result = 0;
        if (A == null || B == null || C == null || D == null) {
            return result;
        }
        if (A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0) {
            return result;
        }
        HashMap<Integer, Integer> sumOfAB = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                sumOfAB.put(a + b,sumOfAB.getOrDefault(a + b,0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                result += sumOfAB.getOrDefault(-c - d,0);
            }
        }
        return result;
    }
}
