package Solutions;

public class Problem0316 {
    public String removeDuplicateLetters(final String s) {
        StringBuilder stack = new StringBuilder();
        boolean[] isInStack = new boolean[256];
        int[] hasNext = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hasNext[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            hasNext[currentChar]--;
            if (!isInStack[currentChar]) {
                while (stack.length() != 0 && stack.charAt(stack.length() - 1) > currentChar && hasNext[stack.charAt(stack.length() - 1)] != 0) {
                    isInStack[stack.charAt(stack.length() - 1)] = false;
                    stack.setLength(stack.length() - 1);
                }
                stack.append(currentChar);
                isInStack[currentChar] = true;
            }
        }
        return stack.toString();
    }
}
