package Solutions;

public class Problem0278 {
    private boolean isBadVersion(int version) {
        return version == 4;
    }

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
