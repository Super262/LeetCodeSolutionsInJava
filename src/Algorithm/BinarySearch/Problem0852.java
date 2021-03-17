package Algorithm.BinarySearch;

public class Problem0852 {
    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int mid;
        int temp;
        while (start < end) {
            mid = start + (end - start) / 2;
            temp = mid + 1;
            if (temp <= end && arr[temp] >= arr[mid]) {
                start = temp;
                continue;
            }
            temp = mid - 1;
            if (temp >= start && arr[temp] >= arr[mid]) {
                end = temp;
                continue;
            }
            return mid;
        }
        return start;
    }
}
