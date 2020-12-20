package solutions.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem1190 {
    public String reverseParentheses(String s) {
        Queue<Character> temp = new LinkedList<>();
        Stack<Character> dataStack = new Stack<>();
        char[] strArray = s.toCharArray();
        StringBuilder result = new StringBuilder();
        for(char c : strArray){
            if (c == ')') {
                while (dataStack.peek() != '(') {
                    temp.add(dataStack.pop());
                }
                dataStack.pop();
                while (!temp.isEmpty()) {
                    dataStack.push(temp.poll());
                }
            } else {
                dataStack.push(c);
            }
        }
        while(!dataStack.empty()){
            result.insert(0,dataStack.pop());
        }
        return result.toString();
    }
}
