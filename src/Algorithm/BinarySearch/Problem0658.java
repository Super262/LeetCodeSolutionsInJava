package Algorithm.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem0658 {
    public List<Integer> findClosestElements(int[] arr,int k,int x) {
        List<Integer> result = new ArrayList<>(k);
        if (arr == null || arr.length == 0) {
            return result;
        }
        int right = findClosestUpper(arr,x);
        int left = right - 1;
        for (int i = 0; i < k; ++i) {
            if (isLeftCloser(x,left,right,arr)) {
                result.add(arr[left]);
                --left;
            } else {
                result.add(arr[right]);
                ++right;
            }
        }
        Collections.sort(result);
        return result;
    }

    private int findClosestUpper(int[] arr,int x) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (arr[mid] >= x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (arr[start] >= x) {
            return start;
        }
        if (arr[end] >= x) {
            return end;
        }
        // 最后一定要返回数组长度作为无效值
        return arr.length;
    }

    private boolean isLeftCloser(int x,int leftIndex,int rightIndex,int[] arr) {
        if (leftIndex < 0) {
            return false;
        }
        if (rightIndex >= arr.length) {
            return true;
        }
        int dl = Math.abs(x - arr[leftIndex]);
        int dr = Math.abs(x - arr[rightIndex]);
        if (dl == dr) {
            return arr[leftIndex] <= arr[rightIndex];
        }
        return dl <= dr;
    }
}
