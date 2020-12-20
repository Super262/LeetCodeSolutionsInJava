package solutions.StackAndQueue;

import java.util.Stack;

public class Problem1209 {
    public String removeDuplicates(String s, int k) {
        Stack<Character> elementStack = new Stack<>();
        Stack<Integer> freqStack = new Stack<>();
        char[] strArray = s.toCharArray();
        StringBuilder result = new StringBuilder();
        for(char c : strArray){
            if(elementStack.empty() || elementStack.peek() != c){
                elementStack.push(c);
                freqStack.push(1);
            }
            else{
                freqStack.push(freqStack.pop() + 1);
            }
            while(!elementStack.empty() && freqStack.peek() > k - 1){
                elementStack.pop();
                freqStack.pop();
            }
        }
        while (!elementStack.empty()){
            for(int i = 0; i < freqStack.peek(); ++i){
                result.insert(0,elementStack.peek());
            }
            elementStack.pop();
            freqStack.pop();
        }
        return result.toString();
    }
}
