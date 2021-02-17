package Algorithm.DynamicProgramming.StockExchange;

import java.util.Arrays;

public class Problem0188 {
    public int maxProfit(int k,int[] prices) {
        if (k == 0 || prices == null || prices.length == 0) {
            return 0;
        }
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy,-prices[0]);
        for (int date = 1; date < prices.length; ++date) {
            buy[0] = Math.max(buy[0],-prices[date]);
            sell[0] = Math.max(sell[0],buy[0] + prices[date]);
            for (int i = 1; i < k; ++i) {
                buy[i] = Math.max(sell[i - 1] - prices[date],buy[i]);
                sell[i] = Math.max(sell[i],buy[i] + prices[date]);
            }
        }
        return sell[k - 1];
    }
}
