package Solutions;

public class Problem0744 {
    public char nextGreatestLetter(char[] letters,char target) {
        if (target >= letters[letters.length - 1] || target < letters[0]) {
            return letters[0];
        }
        int l = 0;
        int h = letters.length - 1;
        int m;
        while (l <= h) {
            m = l + (h - l) / 2;
            if (letters[m] < target) {
                l = m + 1;
            } else if (letters[m] == target) {
                h = m;
                break;
            } else {
                h = m - 1;
            }
        }
        for (int i = h; i < letters.length; ++i) {
            if (letters[i] > target) {
                return letters[i];
            }
        }
        return letters[0];
    }
}
