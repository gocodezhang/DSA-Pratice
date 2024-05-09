public class ClimbingStairs {
    public int findNumberOfWays(int n) {
        int[] memo = new int[n + 1];
        return dfs(n, memo);
    }
    public int dfs(int remaining, int[] memo) {
        // base case
        if (remaining < 0) {
            return 0;
        }
        if (remaining == 0) {
            return 1;
        }
        if (memo[remaining] != 0) {
            return memo[remaining];
        }

        // recursive case
        int result = dfs(remaining -1, memo) + dfs(remaining -2, memo);
        memo[remaining] = result;
        return result;
    }
    public int findNumberOfWaysIterative(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        if (n <= 1) {
            return dp[n];
        }
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.findNumberOfWays(10));
        System.out.println(climbingStairs.findNumberOfWaysIterative(10));
    }

}
