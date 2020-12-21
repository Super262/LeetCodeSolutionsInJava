package solutions.StackAndQueue;

public class Problem1598 {
    public int minOperations(String[] logs) {
        int stepsCount = 0;
        for (String log : logs){
            if(!log.isEmpty() && log.charAt(0) == '.'){
                if(log.length() > 1 && log.charAt(1) == '.'){
                    stepsCount = (stepsCount > 0 ? stepsCount - 1 : 0);
                }
            }
            else{
                ++stepsCount;
            }
        }
        return stepsCount;
    }
}
