package solutions.StackAndQueue;

public class Problem0224 {
    public int calculate(String s) {
        s = '(' + s + ')';
        final int strLen = s.length();
        final int[] numbersStack = new int[strLen];
        final char[] operatorsStack =  new char[strLen];
        int numStackPeek = -1;
        int opStackSize = 0, opStackPeek = -1;
        boolean prevCharIsNum = false;
        for (int i = 0; i < strLen; ++i){
            char ch = s.charAt(i);
            if(ch == '('){
                operatorsStack[++opStackPeek] = ch;
                ++opStackSize;
                prevCharIsNum = false;
            }
            else if (ch == '+' || ch == '-'){
                while(opStackSize > 0 && operatorsStack[opStackPeek] != '('){
                    final int b = numbersStack[numStackPeek--];

                    final int a = numbersStack[numStackPeek--];

                    numbersStack[++numStackPeek] = doOperation(a, b, operatorsStack[opStackPeek--]);
                    --opStackSize;
                }
                operatorsStack[++opStackPeek] = ch;
                ++opStackSize;
                prevCharIsNum = false;
            }
            else if (ch >= '0' && ch <= '9'){
                int digit = ch - '0';
                if (prevCharIsNum){
                    numbersStack[numStackPeek] = numbersStack[numStackPeek] * 10 + digit;
                }
                else{
                    numbersStack[++numStackPeek] = digit;
                }
                prevCharIsNum = true;
            }
            else if (ch == ')'){
                while(operatorsStack[opStackPeek] != '('){
                    final int b = numbersStack[numStackPeek--];

                    final int a = numbersStack[numStackPeek--];

                    numbersStack[++numStackPeek] = doOperation(a, b, operatorsStack[opStackPeek--]);
                    --opStackSize;
                }
                --opStackPeek;
                --opStackSize;
                prevCharIsNum = false;
            }
            else{
                prevCharIsNum = false;
            }
        }
        return numbersStack[numStackPeek];
    }

    private int doOperation (int a, int b, char op){
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
            default:{
                break;
            }
        }
        return result;
    }
}
