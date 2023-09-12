import java.util.Arrays;

public class BestTimeBuySellStockWithCooldown {
    public static int maxProfit(int[] prices) {
        int[] sold = new int[prices.length];
        int[] held = new int[prices.length];
        int[] reset = new int[prices.length];
        held[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sold[i] = prices[i] + held[i - 1];
            held[i] = Math.max(held[i - 1], reset[i - 1] - prices[i]);
            reset[i] = Math.max(sold[i - 1], reset[i - 1]);
        }
        return Math.max(sold[prices.length - 1], reset[prices.length - 1]);
    }
    public static int maxProfitDFS(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, prices, 0, memo);
    }
    public static int dfs(int currPos, int[] prices, int state, int[][] memo) {
        // base case
        // if i >= prices.length
        if (currPos >= prices.length) {
            return 0;
        }
        // if memo[i][state] != -1
        if (memo[currPos][state] != -1) {
            return memo[currPos][state];
        }
        // recursive case
        int idle = dfs(currPos + 1, prices, state, memo);
        // if ( prevAction == 0)
        int option;
        if (state == 0) {
            option = dfs(currPos + 1, prices, 1, memo) - prices[currPos];
        } else {
            option = dfs(currPos + 2, prices, 0, memo) + prices[currPos];
        }
        // max(idle, option)
        memo[currPos][state] = Math.max(idle, option);
        return memo[currPos][state];
    }
    public static void main(String[] main) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfitDFS(prices));
    }
}
