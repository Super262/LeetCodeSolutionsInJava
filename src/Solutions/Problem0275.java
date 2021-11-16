package Solutions;

public class Problem0275 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (citations[n - mid] >= mid) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
