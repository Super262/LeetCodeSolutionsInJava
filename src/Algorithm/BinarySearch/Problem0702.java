package Algorithm.BinarySearch;

public class Problem0702 {
    public int search(ArrayReader reader,int target) {
        int kth = 1;
        while (reader.get(kth - 1) < target) {
            kth *= 2;
        }
        int start = 0;
        int end = kth - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }

    private static class ArrayReader {
        public int get(int index) {
            return index;
        }
    }
}
