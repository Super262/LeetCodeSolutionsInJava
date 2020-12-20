package solutions.StackAndQueue;

import java.util.ArrayList;

public class Problem1249 {
    public String minRemoveToMakeValid(String s) {
        ArrayList<Integer> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i){
            switch (s.charAt(i)){
                case '(':{
                    stack.add(i);
                    break;
                }
                case ')':{
                    if (!stack.isEmpty() && s.charAt(stack.get(stack.size() - 1)) == '('){
                        stack.remove(stack.size() - 1);
                    }
                    else{
                        stack.add(i);
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); ++i){
            if (!stack.isEmpty() && i == stack.get(0)){
                stack.remove(0);
            }
            else{
                stringBuilder.append(s.charAt(i));
            }
        }
        return  stringBuilder.toString();
    }
}
