package solutions.StackAndQueue;

public class Problem0331 {
    public boolean isValidSerialization(final String preorder) {
        int remainder = 1;
        boolean lookingForParenthesis = false;
        for (int i = 0; i < preorder.length(); ++i) {
            if (preorder.charAt(i) == ',' || lookingForParenthesis) {
                lookingForParenthesis = false;
                continue;
            } else {
                lookingForParenthesis = true;
            }
            --remainder;
            if (remainder < 0) {
                return false;
            }
            if (preorder.charAt(i) != '#') {
                remainder += 2;
            }
        }
        return remainder == 0;
    }
}
