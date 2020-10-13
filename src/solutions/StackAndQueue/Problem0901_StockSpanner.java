package solutions.StackAndQueue;

import java.util.Stack;

public class Problem0901_StockSpanner {
    // 将span的大小转化为当前价格距上一个更大的价格的天数

    private Stack<Integer> asecStack, spanStack;

    public Problem0901_StockSpanner() {
        asecStack = new Stack<>();
        spanStack = new Stack<>();
    }
    public int next(int price) {
        int span = 1;
        while(!asecStack.empty() && asecStack.peek() <= price){
            asecStack.pop();
            span += spanStack.pop();
        }
        asecStack.push(price);
        spanStack.push(span);
        return span;
    }
}
