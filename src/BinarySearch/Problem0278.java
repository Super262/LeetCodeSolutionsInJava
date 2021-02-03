package BinarySearch;

public class Problem0278 {
    private boolean isBadVersion(int version) {
        return version == 4;
    }

    public int firstBadVersion(int n) {
        if (n == 1) {
            return 1;
        }
        int low = 1;
        int high = n;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                if (mid == low || !isBadVersion(mid - 1)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return n;
    }
}
