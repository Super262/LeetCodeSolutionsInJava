package DynamicProgramming.StockExchange;

public class Problem0309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int cur0 = -prices[0];
        int cur1 = 0;
        int cur2 = 0;
        int prev0;
        int prev1;
        int prev2;
        for (int date = 1; date < prices.length; ++date) {
            prev0 = cur0;
            prev1 = cur1;
            prev2 = cur2;
            cur0 = Math.max(prev0,cur2 - prices[date]);
            cur1 = prev0 + prices[date];
            cur2 = Math.max(prev1,prev2);
        }
        return Math.max(cur1,cur2);
    }
}
