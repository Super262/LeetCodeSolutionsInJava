package Algorithm.GreedyStrategy;

import java.util.Arrays;

public class Problem0621 {
    public int leastInterval(char[] tasks,int n) {
        if (n == 0) {
            return tasks.length;
        }
        int[] taskFrequency = new int[26];
        for (char t : tasks) {
            ++taskFrequency[t - 'A'];
        }
        Arrays.sort(taskFrequency);
        int lastPartLen = 0;
        for (int i = taskFrequency.length - 1; i >= 0; --i) {
            lastPartLen += taskFrequency[i] == taskFrequency[taskFrequency.length - 1] ? 1 : 0;
        }
        return Math.max(tasks.length,(n + 1) * (taskFrequency[taskFrequency.length - 1] - 1) + lastPartLen);
    }
}
