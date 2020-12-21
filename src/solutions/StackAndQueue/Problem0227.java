package solutions.StackAndQueue;

import java.util.Stack;

public class Problem0227 {
    public int calculate(String s) {
        Stack<Character> operatorsStack = new Stack<>();
        Stack<Integer> numbersStack = new Stack<>();
        final int strLen = s.length();
        boolean prevInIsNum = false;
        for (int i = 0; i < strLen; ++i){
            char ch = s.charAt(i);
            switch (ch){
                case '+':
                case '-': {
                    prevInIsNum = false;
                    calculateExpr(operatorsStack,numbersStack, false);
                    operatorsStack.push(ch);
                    break;
                }
                case '*':
                case '/': {
                    prevInIsNum = false;
                    calculateExpr(operatorsStack,numbersStack, true);
                    operatorsStack.push(ch);
                    break;
                }
                case ' ':{
                    prevInIsNum = false;
                    break;
                }
                default:{
                    int digit = ch - '0';
                    if(prevInIsNum){
                        final int tempNum = numbersStack.pop() * 10 + digit;
                        numbersStack.push(tempNum);
                    }
                    else{
                        prevInIsNum = true;
                        numbersStack.push(digit);
                    }
                    break;
                }
            }
        }
        calculateExpr(operatorsStack,numbersStack, false);
        return numbersStack.pop();
    }

    private void calculateExpr(Stack<Character> operatorsStack,Stack<Integer> numbersStack, boolean beforeMulOrDiv) {
        if (beforeMulOrDiv){
            while (!operatorsStack.empty() && (operatorsStack.peek() == '/' || operatorsStack.peek() == '*')){
                final char op = operatorsStack.pop();
                final int b = numbersStack.pop();
                final int a = numbersStack.pop();
                int result = 0;
                switch (op){
                    case '*':{
                        result = a * b;
                        break;
                    }
                    case '/':{
                        result = a / b;
                        break;
                    }
                }
                numbersStack.push(result);
            }
        }
        else{
            while (!operatorsStack.empty()){
                final char op = operatorsStack.pop();
                final int b = numbersStack.pop();
                final int a = numbersStack.pop();
                int result = 0;
                switch (op){
                    case '+':{
                        result = a + b;
                        break;
                    }
                    case '-':{
                        result = a - b;
                        break;
                    }
                    case '*':{
                        result = a * b;
                        break;
                    }
                    case '/':{
                        result = a / b;
                        break;
                    }
                }
                numbersStack.push(result);
            }
        }
    }
}
