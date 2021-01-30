package solutions.StackAndQueue;

import java.util.Stack;

public class Problem0591 {
    public boolean isValid(final String code) {
        final int codeLength = code.length();
        if (codeLength < 7 || code.charAt(0) != '<' || !Character.isUpperCase(code.charAt(1))){
            return false;
        }

        Stack<String> tagStack = new Stack<>();
        boolean isInTagContent = false;
        boolean alreadyHasOneClosedTag = false;

        StringBuilder tempStr = new StringBuilder();
        int i = 0;
        while (i < codeLength){
            if(alreadyHasOneClosedTag){
                return false;
            }
            char ch = code.charAt(i);
            if (ch == '<'){
                if (i + 1 >= codeLength){
                    return false;
                }
                if (code.charAt(i + 1) == '/'){
                    i += 2;
                    while (i < codeLength && code.charAt(i) != '>'){
                        if (Character.isUpperCase(code.charAt(i))){
                            tempStr.append(code.charAt(i));
                            i++;
                        } else {
                            return false;
                        }
                    }
                    if (i >= codeLength || code.charAt(i) != '>'){
                        return false;
                    }
                    if (!tagStack.empty() && tempStr.toString().equals(tagStack.peek())){
                        tagStack.pop();
                        if (tagStack.empty()){
                            isInTagContent = false;
                            alreadyHasOneClosedTag = true;
                        }
                        i++;
                        tempStr.setLength(0);

                    } else {
                        return false;
                    }

                } else if (Character.isUpperCase(code.charAt(i + 1))){
                    i++;
                    while (i < codeLength && code.charAt(i) != '>'){
                        if (Character.isUpperCase(code.charAt(i))){
                            tempStr.append(code.charAt(i));
                            i++;
                        } else {
                            return false;
                        }
                    }
                    if (i >= codeLength || code.charAt(i) != '>'){
                        return false;
                    }
                    if(tempStr.length() > 0 && tempStr.length() < 10) {
                        tagStack.push(tempStr.toString());
                        tempStr.setLength(0);
                        isInTagContent = true;
                        i++;
                    } else {
                        return false;
                    }

                } else if (code.substring(i, (Math.min(i + 9,codeLength))).equals("<![CDATA[")){
                    i += 9;
                    while (i < codeLength && i + 2 < codeLength && !code.startsWith("]]>",i)){
                        i++;
                    }
                    if (i >= codeLength || i + 2 >= codeLength){
                        return false;
                    }
                    i += 3;

                } else {
                    return false;
                }
            } else if (ch == '>' || ch == '/' || ch == '!' || ch == '[' || ch == ']' || ch == ' '
                    || Character.isDigit(ch) || Character.isUpperCase(ch) || Character.isLowerCase(ch)) {
                if (!isInTagContent){
                    return false;
                }
                i++;
            } else {
                return false;
            }
        }

        return tagStack.empty();
    }
}
