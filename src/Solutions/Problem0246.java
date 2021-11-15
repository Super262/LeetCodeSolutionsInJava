package Solutions;

public class Problem0246 {
    public boolean isStrobogrammatic(final String num) {
        int l = 0;
        int r = num.length() - 1;
        while (l <= r) {
            if (num.charAt(l) == '2' || num.charAt(l) == '3' || num.charAt(l) == '4' || num.charAt(l) == '5' || num.charAt(l) == '7') {
                return false;
            }
            if (num.charAt(r) == '2' || num.charAt(r) == '3' || num.charAt(r) == '4' || num.charAt(r) == '5' || num.charAt(r) == '7') {
                return false;
            }
            if (num.charAt(l) == '0') {
                if (num.charAt(r) != '0') {
                    return false;
                }
            } else if (num.charAt(l) == '1') {
                if (num.charAt(r) != '1') {
                    return false;
                }
            } else if (num.charAt(l) == '6') {
                if (num.charAt(r) != '9') {
                    return false;
                }
            } else if (num.charAt(l) == '8') {
                if (num.charAt(r) != '8') {
                    return false;
                }
            } else if (num.charAt(l) == '9') {
                if (num.charAt(r) != '6') {
                    return false;
                }
            }
            ++l;
            --r;
        }
        return true;
    }
}
