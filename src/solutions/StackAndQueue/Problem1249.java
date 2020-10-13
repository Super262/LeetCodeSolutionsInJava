package solutions.StackAndQueue;

import java.util.Stack;

public class Problem1249 {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] toBeRemoved = new boolean[s.length()];
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            switch(s.charAt(i)){
                case '(':{
                    stack.push(i);
                    break;
                }
                case ')':{
                    if(stack.empty()){
                        toBeRemoved[i] = true;
                    }
                    else{
                        stack.pop();
                    }
                    break;
                }
            }
        }
        while(!stack.empty()){
            toBeRemoved[stack.pop()] = true;
        }
        for(int i = 0; i < s.length(); ++i){
            if(!toBeRemoved[i]){
                str.append(s.charAt(i));
            }
        }
        return  str.toString();
    }
}
