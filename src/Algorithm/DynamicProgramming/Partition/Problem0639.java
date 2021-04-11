package Algorithm.DynamicProgramming.Partition;

public class Problem0639 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 1;
        }
        final int maxBound = 1000000007;
        final int N = s.length();

        // 使用int会导致溢出
        long f0 = 1;
        long f1 = countOne(s,0) * f0;
        long f2;
        for (int l = 2; l <= N; ++l) {
            f2 = f1 * countOne(s,l - 1) % maxBound + f0 * countTwo(s,l - 2) % maxBound;
            f2 %= maxBound;
            f0 = f1;
            f1 = f2;
        }
        return (int) f1;
    }

    private int countOne(String s,int start) {
        if (s.charAt(start) == '0') {
            return 0;
        } else if (s.charAt(start) == '*') {
            return 9;
        }
        return 1;
    }

    private int countTwo(String s,int start) {
        if (s.charAt(start) == '*') {
            if (s.charAt(start + 1) == '*') {
                return 15;
            } else if (s.charAt(start + 1) > '6') {
                return 1;
            } else {
                return 2;
            }
        } else if (s.charAt(start) == '1') {
            if (s.charAt(start + 1) == '*') {
                return 9;
            } else {
                return 1;
            }
        } else if (s.charAt(start) == '2') {
            if (s.charAt(start + 1) == '*') {
                return 6;
            } else if (s.charAt(start + 1) > '6') {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }
}
