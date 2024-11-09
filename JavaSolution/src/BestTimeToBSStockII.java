/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 */
public class BestTimeToBSStockII {
    public int maxProfit(int[] prices) {
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
    public int maxProfitBest(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                int gain = prices[i] - prices[i - 1];
                maxProfit += gain;
            }
        }
        return maxProfit;
    }
    public int maxProfitTwoPointers(int[] prices) {
        // global variable
        int totalProfit = 0;
        // left, right
        int left = 0;
        int right = 1;
        // go though arrays
        while (right < prices.length) {
            // left >= right; update window and do nothing
            if (prices[left] >= prices[right]) {
                left++;
                right++;
            } else {
                if (right == prices.length - 1 || prices[right] >= prices[right + 1]) {
                    totalProfit += prices[right] - prices[left];
                    left = right + 1;
                    right = left + 1;
                } else {
                    right++;
                }
            }
        }

        return totalProfit;
    }
    public int maxProfitTwoPointersOptimal(int[] prices) {
        int totalProfit = 0;
        int i = 0;

        while (i < prices.length) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            int valley = prices[i];

            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            int peak = prices[i];
            totalProfit += peak - valley;
            i++;
        }

        return totalProfit;
    }
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        BestTimeToBSStockII bestTimeToBSStockII = new BestTimeToBSStockII();
        System.out.println(bestTimeToBSStockII.maxProfit(prices));
    }
}
