package solutions.StackAndQueue;

import java.util.Stack;

public class Problem0907 {
    public int sumSubarrayMins(int[] A) {
        long sum = 0, base = (long) (Math.pow(10,9) + 7);
        int[] leftLess = new int[A.length], rightLess = new int[A.length];
        Stack<Integer> temp1 = new Stack<>(), temp2 = new Stack<>();

        // 注意两次循环出栈的条件：一次有等于（>=），一次没有（>）-> 应对特殊情况：序列中有2个数相等。
        // 如果不作处理，这两个相等的数，会使子序列重复

        for (int i = 0; i < A.length; ++i) {
            while (!temp1.empty() && A[temp1.peek()] > A[i]) {
                temp1.pop();
            }
            if (temp1.empty()) {
                leftLess[i] = -1;
            } else {
                leftLess[i] = temp1.peek();
            }
            temp1.push(i);
        }
        for (int i = A.length - 1; i >= 0; --i) {
            while (!temp2.empty() && A[temp2.peek()] >= A[i]) {
                temp2.pop();
            }
            if (temp2.empty()) {
                rightLess[i] = A.length;
            } else {
                rightLess[i] = temp2.peek();
            }
            temp2.push(i);
        }
        for (int i = 0; i < A.length; ++i) {
            sum += ((long) A[i]) * ((long) rightLess[i] - (long) i) * ((long) i - (long) leftLess[i]);
        }
        return (int) (sum % base);
    }
}
