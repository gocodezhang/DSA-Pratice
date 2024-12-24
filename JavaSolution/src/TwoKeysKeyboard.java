import java.util.Arrays;

public class TwoKeysKeyboard {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }

        Integer[][] memo = new Integer[n][n];

        return dfs(n, n - 1, 1, memo) + 1;
    }
    public int dfs(int n, int remaining, int base, Integer[][] memo) {
        if (remaining == 0) {
            return 0;
        }
        if (remaining % base != 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[remaining][base] != null) {
            return memo[remaining][base];
        }

        // recursive case
        int result = Integer.MAX_VALUE;
        if (n - remaining > base) {
            int copy = dfs(n, remaining, n - remaining, memo);
            result = Math.min(result, copy);
        }
        int paste = dfs(n, remaining - base, base, memo);

        result = Math.min(result, paste);

        int finalResult = result == Integer.MAX_VALUE ? result : result + 1;
        memo[remaining][base] = finalResult;

        return finalResult;
    }
    public int minStepsDp(int n) {
        if (n == 1) {
            return 0;
        }
        int[][] dp = new int[n + 1][n];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[1][1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= Math.min(i, n - 1); j++) {
                int result = Integer.MAX_VALUE;
                if (i > j) {
                    result = Math.min(result, dp[i - j][j]);
                }
                if (result != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], result + 1);
                }
                if (i < n && dp[i][j] != Integer.MAX_VALUE) {
                    dp[i][i] = Math.min(dp[i][i], dp[i][j] + 1);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, dp[n][i]);
        }

        return min;
    }
    public int minStepsDpOptimized(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        TwoKeysKeyboard twoKeysKeyboard = new TwoKeysKeyboard();
        System.out.println(twoKeysKeyboard.minStepsDp(6));
    }
}
