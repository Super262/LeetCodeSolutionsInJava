package Algorithm.DynamicProgramming.Partition;

import java.util.LinkedList;
import java.util.List;

public class Problem0279 {
    public int numSquares(int n) {
        List<Integer> squareList = generateSquares(n);
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int tempMin;
        for (int digit = 2; digit <= n; ++digit) {
            tempMin = Integer.MAX_VALUE;
            for (int currentSquare : squareList) {
                if (currentSquare > digit) {
                    break;
                } else if (currentSquare == digit) {
                    tempMin = 1;
                    break;
                } else {
                    tempMin = Math.min(tempMin,dp[digit - currentSquare] + 1);
                }
            }
            dp[digit] = tempMin;
        }
        return dp[n];
    }

    private List<Integer> generateSquares(int upperbound) {
        LinkedList<Integer> result = new LinkedList<>();
        int num = 1;
        while (result.isEmpty() || result.peekLast() < upperbound) {
            result.addLast(num * num);
            ++num;
        }
        if (result.peekLast() > upperbound) {
            result.removeLast();
        }
        return result;
    }
}
