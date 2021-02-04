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
                if (sLen == 1) {
                    result.add(s);
                }
            } else {
                int value = Integer.parseInt(s);
                if (value > 0 && value < 256) {
                    result.add(s);
                }
            }
        } else {
            StringBuilder tempValue = new StringBuilder();
            int initialLen;
            if (s.charAt(0) == '0') {
                tempValue.append("0.");
                initialLen = tempValue.length();
                for (String postfix : splitToIntegers(count - 1,s.substring(1))) {
                    tempValue.append(postfix);
                    result.add(tempValue.toString());
                    tempValue.setLength(initialLen);
                }
            } else {
                int value;
                for (int i = 1; i < sLen && i < 4; ++i) {
                    value = Integer.parseInt(s.substring(0,i));
                    if (value > 0 && value < 256) {
                        tempValue.setLength(0);
                        tempValue.append(value);
                        tempValue.append('.');
                        initialLen = tempValue.length();
                        for (String postfix : splitToIntegers(count - 1,s.substring(i))) {
                            tempValue.append(postfix);
                            result.add(tempValue.toString());
                            tempValue.setLength(initialLen);
                        }
                    }
                }
            }
        }
        return result;
    }
}
