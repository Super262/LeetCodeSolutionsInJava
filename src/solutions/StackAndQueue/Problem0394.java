package solutions.StackAndQueue;

import java.util.Stack;

public class Problem0394 {
    public String decodeString(final String s) {
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> factorStack = new Stack<>();
        boolean preIsNum = false;
        StringBuilder resultStringBuilder = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                if(preIsNum){
                    final int preNum = factorStack.pop() * 10;
                    factorStack.push((ch - '0') + preNum);
                }
                else{
                    factorStack.push(ch - '0');
                }
                preIsNum = true;
            }
            else if (ch == '['){
                strStack.push(new StringBuilder());
                preIsNum = false;
            }
            else if (ch == ']'){
                final int factor = factorStack.pop();
                final String strEle = strStack.pop().toString();
                StringBuilder tempResultStringBuilder = new StringBuilder();
                tempResultStringBuilder.append(strEle.repeat(Math.max(0,factor)));
                if(strStack.empty()){
                    resultStringBuilder.append(tempResultStringBuilder);
                }
                else{
                    strStack.peek().append(tempResultStringBuilder);
                }
                preIsNum = false;
            }
            else{
                if(strStack.empty()){
                    resultStringBuilder.append(ch);
                }
                else{
                    strStack.peek().append(ch);
                }
                preIsNum = false;
            }
        }
        return resultStringBuilder.toString();
    }
}
