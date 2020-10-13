package solutions.StackAndQueue;

import java.util.Stack;

public class Problem0921 {
    public int minAddToMakeValid(String S) {
        Stack<Character> temp = new Stack<>();
        int remainder = 0;
        for(char c : S.toCharArray()){
            switch(c){
                case '(':{
                    temp.push(c);
                    break;
                }
                case ')':{
                    if(!temp.empty() && temp.peek() == '('){
                        temp.pop();
                    }
                    else{
                        ++remainder;
                    }
                    break;
                }
            }
        }
        remainder += temp.size();
        return remainder;
    }
}
