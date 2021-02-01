package solutions.StackAndQueue;

import java.util.Stack;

public class Problem0901_StockSpanner {
    // 采用"最小栈"思想

    private final Stack<Integer> asecStack;
    private final Stack<Integer> spanStack;

    public Problem0901_StockSpanner() {
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
