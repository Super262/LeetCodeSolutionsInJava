package Solutions;

import java.util.Stack;

public class Problem1124 {
    public int longestWPI(int[] hours) {
        int result = 0;
        int[] scores = new int[hours.length];
        int[] presum = new int[hours.length + 1];
        Stack<Integer> descStack = new Stack<>();
        for (int i = 0; i < hours.length; ++i) {
            if (hours[i] < 9) {
                scores[i] = -1;
            } else {
                scores[i] = 1;
            }
        }
        for (int i = 1; i < presum.length; ++i) {
            presum[i] = presum[i - 1] + scores[i - 1];
        }

        // 构建单调栈，从前缀和的第一个元素开始
        // 由于presum[0] = 0，所以单调栈中的元素全部小于等于0，一定是presum中最小的一部分元素！！
        for (int i = 0; i < presum.length; ++i) {
            if (descStack.empty() || presum[descStack.peek()] > presum[i]) {
                descStack.push(i);
            }
        }
        for (int i = hours.length; i >= result; --i) {
            while (!descStack.empty() && presum[descStack.peek()] < presum[i]) {
                result = Math.max(result,i - descStack.peek());
                descStack.pop();
            }
        }
        return result;
    }
}
