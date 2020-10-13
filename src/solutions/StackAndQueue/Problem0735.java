package solutions.StackAndQueue;

import java.util.Stack;

public class Problem0735 {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length == 0){
            return new int[0];
        }
        if(asteroids.length == 1){
            return asteroids;
        }
        Stack<Integer> temp = new Stack<>();
        for(int as : asteroids){
            if(temp.empty() || !(temp.peek() > 0 && as < 0)){
                temp.push(as);
            }
            else{
                boolean allExploded = false;
                while (!temp.empty() && (temp.peek() > 0 && as < 0)){
                    if(Math.abs(temp.peek()) == Math.abs(as)){
                        temp.pop();
                        allExploded = true;
                        break;
                    }
                    else{
                        int p = temp.peek();
                        temp.pop();
                        as = Math.abs(p) > Math.abs(as) ? p : as;
                    }
                }
                if(!allExploded){
                    temp.push(as);
                }
            }
        }
        int[] result = new int[temp.size()];
        for(int i = result.length - 1; i >= 0; --i){
            result[i] = temp.pop();
        }
        return  result;
    }
}
