package Algorithm.BinarySearch;

public class Problem0069 {
    public int mySqrt(int x) {
        long l = 0;
        long h = x;
        long m;
        long tempRes;
        while (l <= h) {
            m = l + (h - l) / 2;
            tempRes = m * m;
            if (tempRes < x) {
                l = m + 1;
            } else if (tempRes == x) {
                return (int) m;
            } else {
                h = m - 1;
            }
        }
        return (int) l;
    }
}
