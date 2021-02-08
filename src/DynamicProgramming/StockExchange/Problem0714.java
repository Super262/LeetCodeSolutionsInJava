package DynamicProgramming.StockExchange;

public class Problem0714 {
    public int maxProfit(int[] prices,int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int cur0 = -prices[0];
        int cur1 = 0;
        int prev0;
        int prev1;
        for (int date = 1; date < prices.length; ++date) {
            prev0 = cur0;
            prev1 = cur1;
            cur0 = Math.max(prev0,prev1 - prices[date]);
            cur1 = Math.max(prev1,prev0 + prices[date] - fee);
        }
        return Math.max(cur0,cur1);
    }
}
