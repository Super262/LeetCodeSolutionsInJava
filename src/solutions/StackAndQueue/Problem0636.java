package solutions.StackAndQueue;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Problem0636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<String[]> logStack =new Stack<>();
        Stack<Integer> timeStack =new Stack<>();
        for(String log : logs){
            String[] logItems = log.split(":");
            if(logItems[1].equals("start")){
                logStack.push(logItems);
                timeStack.push(0);
            }
            else{
                String[] startLogItems = logStack.pop();
                int endTime = Integer.parseInt(logItems[2]);
                int startTime = Integer.parseInt(startLogItems[2]);
                int duration = endTime - startTime + 1 + timeStack.pop();
                result[Integer.parseInt(logItems[0])] += duration;
                if(!timeStack.empty()){
                    int lastFuncDuration = timeStack.pop() - (endTime - startTime + 1);
                    timeStack.push(lastFuncDuration);
                }
            }
        }
        return result;
    }
}
