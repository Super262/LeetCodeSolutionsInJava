package solutions.StackAndQueue;

import java.util.Stack;

public class Problem1209 {
    public String removeDuplicates(String s, int k) {
        Stack<Character> alphaStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        for(int i = 0; i < s.length(); ++i){
            final char ch = s.charAt(i);
            if(!alphaStack.empty() && alphaStack.peek() == ch){
                countStack.push(countStack.pop() + 1);
            }
            else{
                countStack.push(1);
                alphaStack.push(ch);
            }
            while(!alphaStack.empty()){
                if(countStack.peek() >= k){
                    countStack.pop();
                    alphaStack.pop();
                }
                else{
                    break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!alphaStack.empty()){
            final char ch = alphaStack.pop();
            final int factor = countStack.pop();
            stringBuilder.append(String.valueOf(ch).repeat(factor));
        }
        return stringBuilder.reverse().toString();
    }
}
