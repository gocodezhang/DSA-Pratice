/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 */
public class BestTimeToBSStockII {
    public static int maxProfit(int[] prices) {
        // create three possible states arrays
        int[] sold = new int[prices.length];
        int[] hold = new int[prices.length];
        int[] reset = new int[prices.length];
        hold[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sold[i] = hold[i - 1] + prices[i];
            hold[i] = Math.max(sold[i - 1] - prices[i], Math.max(reset[i - 1] - prices[i], hold[i - 1]));
            reset[i] = Math.max(reset[i - 1], sold[i - 1]);
        }
        return Math.max(sold[prices.length - 1], reset[prices.length - 1]);
    }
    public static int maxProfitValleyApproach(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                int gain = prices[i] - prices[i - 1];
                maxProfit += gain;
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }
}
