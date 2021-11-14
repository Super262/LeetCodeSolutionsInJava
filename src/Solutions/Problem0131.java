package Solutions;

import java.util.LinkedList;
import java.util.List;

public class Problem0131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        if (s != null && !s.isEmpty()) {
            final int sLen = s.length();
            if (sLen == 1) {
                List<String> selfList = new LinkedList<>();
                selfList.add(s);
                result.add(selfList);
            } else {
                if (isPalindrome(s,sLen)) {
                    List<String> selfList = new LinkedList<>();
                    selfList.add(s);
                    result.add(selfList);
                }
                for (int i = 1; i < sLen; ++i) {
                    if (isPalindrome(s,i)) {
                        List<List<String>> tempResult = partition(s.substring(i));
                        for (List<String> l : tempResult) {
                            l.add(0,s.substring(0,i));
                        }
                        result.addAll(tempResult);
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s,int end) {
        end = end - 1;
        int i = 0;
        while (i < end) {
            if (s.charAt(i++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
