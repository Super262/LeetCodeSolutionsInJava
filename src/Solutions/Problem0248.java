package Solutions;

class Problem0248 {
    private int result;

    public int strobogrammaticInRange(final String low,final String high) {
        result = 0;
        dfs("",low,high);
        dfs("0",low,high);
        dfs("1",low,high);
        dfs("8",low,high);
        return result;
    }

    private void dfs(final String s,final String low,final String high) {
        if (s.length() > high.length()) {
            return;
        }
        if (s.length() >= low.length()) {
            if (isInRange(s,low,high)) {
                ++result;
            }
        }
        if (s.length() + 2 > high.length()) {
            return;
        }
        final String[] head = {"0","1","6","8","9"};
        final String[] tail = {"0","1","9","8","6"};
        for (int i = 0; i < head.length; ++i) {
            dfs(head[i] + s + tail[i],low,high);
        }
    }

    private boolean isInRange(final String s,final String low,final String high) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        if (s.length() < low.length() || s.length() > high.length()) {
            return false;
        }
        if (s.length() > low.length() && s.length() < high.length()) {
            return true;
        }
        if (s.length() == low.length() && low.length() == high.length()) {
            return s.compareTo(low) >= 0 && s.compareTo(high) <= 0;
        }
        if (s.length() == low.length()) {
            return s.compareTo(low) >= 0;
        }
        if (s.length() == high.length()) {
            return s.compareTo(high) <= 0;
        }
        return false;
    }
}
