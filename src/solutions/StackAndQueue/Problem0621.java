package solutions.StackAndQueue;

import java.util.Arrays;

public class Problem0621 {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length == 0 || tasks.length == 1 || n == 0){
            return tasks.length;
        }
        else{
            int timeCost = 0;
            final int TASK_TYPE = 26;
            int[] frequency = new int[TASK_TYPE];
            for(char task : tasks){
                ++frequency[task - 'A'];
            }
            Arrays.sort(frequency);
            while(frequency[TASK_TYPE - 1] > 0){
                int i = 0;
                while(i <= n){
                    if(frequency[TASK_TYPE - 1] == 0){
                        break;
                    }
                    else{
                        if(i < TASK_TYPE){
                            frequency[TASK_TYPE - 1 - i] = frequency[TASK_TYPE - 1 - i] > 0 ? frequency[TASK_TYPE - 1 - i] - 1 : 0;
                        }
                        ++i;
                        ++timeCost;
                    }
                }
                Arrays.sort(frequency);
            }
            return timeCost;
        }
    }
}
