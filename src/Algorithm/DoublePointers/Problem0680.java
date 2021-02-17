package Algorithm.DoublePointers;

public class Problem0680 {
    public boolean validPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                break;
            }
            ++low;
            --high;
        }
        if (low >= high) {
            return true;
        }
        return isPalindrome(s,low,high - 1) || isPalindrome(s,low + 1,high);
    }

    private boolean isPalindrome(String s,int start,int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }
}
