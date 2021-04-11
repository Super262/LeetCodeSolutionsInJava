package Algorithm.DynamicProgramming.Partition;

public class Problem0091 {
    public int numDecodings(String s) {
        if (s == null) {
            return 1;
        }
        int sLen = s.length();
        if (sLen == 0) {
            return 1;
        }
        int f0 = 1;
        int f1 = s.charAt(0) == '0' ? 0 : 1;
        int f2 = 0;
        for (int l = 2; l <= sLen; ++l) {
            if (s.charAt(l - 1) != '0') {
                f2 += f1;
            }
            if (s.charAt(l - 2) != '0') {
                if ((s.charAt(l - 2) - '0') * 10 + (s.charAt(l - 1) - '0') < 27) {
                    f2 += f0;
                }
            }
            f0 = f1;
            f1 = f2;
            f2 = 0;
        }
        return f1;
    }
}
