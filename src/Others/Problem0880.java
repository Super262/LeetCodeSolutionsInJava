package Others;

public class Problem0880 {
    public String decodeAtIndex(String S,int K) {
        long size = 0;

        // Find size = length of decoded string
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (Character.isDigit(ch)) size *= ch - '0';
            else size++;
        }


        for (int i = S.length() - 1; i >= 0; --i) {

            // This is quite tricky.
            K %= size;
            char ch = S.charAt(i);
            if (Character.isDigit(ch)) {
                size /= (ch - '0');
            } else {
                if (K == 0) {
                    return String.valueOf(ch);
                }
                // Decrease the size while move one step.
                --size;
            }
        }
        return "";
    }
}
