package solutions.StackAndQueue;

import java.util.Stack;

public class Problem0907 {
    public int sumSubarrayMins(int[] A) {
        long sum = 0, base = (long) (Math.pow(10, 9) + 7);
        int[] leftLess = new int[A.length], rightLess = new int[A.length];
        Stack<Integer> temp = new Stack<>();
        // 注意两次循环出栈的条件：一次有等于，一次没有 -> 应对特殊情况：序列中有2个数相等。
        // 如果不作处理，这两个相等的数，会使子序列重复
        for(int i = 0; i < A.length; ++i){
            while(!temp.empty() && A[temp.peek()] > A[i]){
                temp.pop();
            }
            if(temp.empty()){
                leftLess[i] = -1;
            }
            else{
                leftLess[i] = temp.peek();
            }
            temp.push(i);
        }
        temp.clear();
        for(int i = A.length - 1; i >= 0; --i){
            while(!temp.empty() && A[temp.peek()] >= A[i]){
                temp.pop();
            }
            if(temp.empty()){
                rightLess[i] = A.length;
            }
            else{
                rightLess[i] = temp.peek();
            }
            temp.push(i);
        }
        for(int i = 0; i < A.length; ++i){
            sum += A[i] * (rightLess[i] - i) * (i - leftLess[i]);
        }
        return (int) (sum % base);
    }
}
