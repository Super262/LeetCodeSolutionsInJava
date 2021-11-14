package Solutions;

import java.util.Stack;

public class Problem0901 {
    private static class StockSpanner {
        // Stack of Minimals

        private final Stack<Integer> asecStack;
        private final Stack<Integer> spanStack;

        public StockSpanner() {
            asecStack = new Stack<>();
            spanStack = new Stack<>();
        }

        public int next(int price) {
            int span = 1;
            while (!asecStack.empty() && asecStack.peek() <= price) {
                asecStack.pop();
                span += spanStack.pop();
            }
            asecStack.push(price);
            spanStack.push(span);
            return span;
        }
    }
}
