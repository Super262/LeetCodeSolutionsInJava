package Solutions;

public class Problem0123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] firstTrans = new int[2];
        int[] secondTrans = new int[2];
        firstTrans[0] = -prices[0];
        secondTrans[0] = -prices[0];
        for (int date = 1; date < prices.length; ++date) {
            firstTrans[0] = Math.max(firstTrans[0],-prices[date]);
            firstTrans[1] = Math.max(firstTrans[1],firstTrans[0] + prices[date]);
            secondTrans[0] = Math.max(secondTrans[0],firstTrans[1] - prices[date]);
            secondTrans[1] = Math.max(secondTrans[1],secondTrans[0] + prices[date]);
        }
        return secondTrans[1];
    }
}
