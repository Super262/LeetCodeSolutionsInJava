package Solutions;

public class Problem0028 {
    public int strStr(String haystack,String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.isEmpty()) {
            return 0;
        }
        int[] next = buildNext(needle);
        int hChIndex = 0;
        int nChIndex = 0;
        while (hChIndex < haystack.length()) {
            if (haystack.charAt(hChIndex) == needle.charAt(nChIndex)) {
                ++hChIndex;
                ++nChIndex;
            } else if (nChIndex != 0) {
                nChIndex = next[nChIndex - 1];
            } else {
                ++hChIndex;
            }
            if (nChIndex == needle.length()) {
                return hChIndex - nChIndex;
            }
        }
        return -1;
    }

    private int[] buildNext(String needle) {
        int[] next = new int[needle.length()];
        int now = 0;
        int x = 1;
        while (x < needle.length()) {
            if (needle.charAt(now) == needle.charAt(x)) {
                ++now;
                next[x] = now;
                ++x;
            } else if (now != 0) {
                now = next[now - 1];
            } else {
                next[x] = 0;
                ++x;
            }
        }
        return next;
    }
}
