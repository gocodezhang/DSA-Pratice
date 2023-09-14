import java.util.Arrays;

public class CoinChangeII {
    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, amount, dp, coins);
    }
    public static int dfs(int startingIndex, int remaining, int[][] dp, int[] coins) {
        // base case
        // if i >= coin.length
        if (startingIndex >= coins.length || remaining < 0) {
            return 0;
        }
        // if remaining == 0
        if (remaining == 0) {
            return 1;
        }
        // if dp[i][remaining] != -1
        if (dp[startingIndex][remaining] != -1) {
            return dp[startingIndex][remaining];
        }
        // recursive case
        // int sum = 0;
        int sum = 0;
        // for coin in coins from i index
        for (int j = startingIndex; j < coins.length; j++) {
            sum += dfs(j, remaining - coins[j], dp, coins);
        }
        // dp[i][remaining] = sum;
        dp[startingIndex][remaining] = sum;
        // return sum
        return sum;
    }
    public static int changeIterative(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < amount + 1; i++) {
            if (i - coins[coins.length - 1] >= 0) {
                dp[coins.length - 1][i] = dp[coins.length - 1][i - coins[coins.length - 1]];
            }
        }
        for (int row = coins.length - 2; row >= 0; row--) {
            for (int col = 0; col < amount + 1; col++) {
                if (col - coins[row] >= 0) {
                    dp[row][col] = dp[row][col - coins[row]] + dp[row + 1][col];
                } else {
                    dp[row][col] = dp[row + 1][col];
                }
            }
        }
        return dp[0][amount];
    }
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(changeIterative(amount, coins));
    }
}
