package solutions.StackAndQueue;

import java.util.Stack;

public class Problem0071 {
    public String simplifyPath(final String path) {
        StringBuilder result = new StringBuilder();
        Stack<Character> temp = new Stack<>();
        int len = path.length();
        for(int i = 0; i < len; ++i){
            if(temp.empty()){
                temp.push(path.charAt(i));
            }
            else{
                switch(path.charAt(i)){
                    case '/':{
                        if(temp.peek() != '/'){
                            temp.push('/');
                        }
                        break;
                    }
                    case '.':{
                        if(i + 2 < len && path.charAt(i) == '.'
                                && path.charAt(i + 1) == '.'
                                && path.charAt(i + 2) == '.'){
                            
                        }
                        if(i + 1 < len && path.charAt(i + 1) == '.'){
                            ++i;
                            temp.pop();
                            while(!temp.empty() && temp.peek() != '/'){
                                temp.pop();
                            }
                            if(temp.empty()){
                                temp.push('/');
                            }
                        }
                        break;
                    }
                    default:{
                        temp.push(path.charAt(i));
                        break;
                    }
                }
            }
        }
        if(temp.size() > 1 && temp.peek() == '/'){
            temp.pop();
        }
        while(!temp.empty()){
            result.insert(0, temp.pop());
        }
        return result.toString();
    }
}
