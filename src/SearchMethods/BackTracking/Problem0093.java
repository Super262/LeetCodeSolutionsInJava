package SearchMethods.BackTracking;

import java.util.LinkedList;
import java.util.List;

public class Problem0093 {
    public List<String> restoreIpAddresses(String s) {
        return splitToIntegers(4,s);
    }

    private List<String> splitToIntegers(final int count,final String s) {
        List<String> result = new LinkedList<>();
        if (s == null) {
            return result;
        }
        final int sLen = s.length();
        if (sLen > count * 3 || sLen < count) {
            return result;
        }
        if (count == 1) {
            if (s.charAt(0) == '0') {
                if (s.equals("0")) {
                    result.add("0");
                }
            } else {
                int value = Integer.parseInt(s);
                if (value > 0 && value < 256) {
                    result.add(s);
                }
            }
        } else {
            if (s.charAt(0) == '0') {
                for (String postfix : splitToIntegers(count - 1,s.substring(1))) {
                    result.add("0." + postfix);
                }
            } else {
                for (int i = 1; i < sLen && i < 4; ++i) {
                    int value = Integer.parseInt(s.substring(0,i));
                    if (value > 0 && value < 256) {
                        for (String postfix : splitToIntegers(count - 1,s.substring(i))) {
                            result.add(value + "." + postfix);
                        }
                    }
                }
            }
        }
        return result;
    }
}
