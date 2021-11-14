package Solutions;

public class Problem1513 {
    public int numSub(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        final int bound = 1000000007;
        int answer = 0;
        int right = 1;
        for (int left = 0; left < s.length(); ++left) {
            if (s.charAt(left) != '1') {
                continue;
            }
            right = Math.max(right,left + 1);
            while (right < s.length() && s.charAt(right) == '1') {
                ++right;
            }
            answer += right - left;
            answer %= bound;
        }
        return answer;
    }
}
