import java.util.Arrays;

public class StoneGameII {
    int[][] logs;
    public int stoneGameIITopDown(int[] piles) {
        int sum = 0;
        int[] suffixSum = new int[piles.length];
        for (int i = piles.length - 1; i >= 0; i--) {
            sum += piles[i];
            suffixSum[i] = sum;
        }
        int[][] memo = new int[piles.length][piles.length];
        return dfs(0, 1, suffixSum, piles, memo);

    }
    public int dfs(int i, int M, int[] suffixSum, int[] piles, int[][] memo) {
        // base case
        if (i >= piles.length) {
            return 0;
        }
        if (M >= piles.length) {
            return suffixSum[i];
        }
        if (memo[i][M] != 0) {
            return memo[i][M];
        }

        // recursive case
        int result = 0;
        for (int j = 0; j < Math.min(2 * M, piles.length - i); j++) {
            result = Math.max(result, suffixSum[i] - dfs(i + j + 1, Math.max(M, j + 1), suffixSum, piles, memo));
        }

        memo[i][M] = result;
        return result;
    }
    public int stoneGameIIBF(int[] piles) {
        return dfsBF(0, 0, 1, piles);
    }
    public int dfsBF(int player, int i, int M, int[] piles) {
        // base case
        if (i >= piles.length) {
            return 0;
        }

        // recursive case
        if (player == 1) {
            // suffix[i] - Alice stone = Bob stone
            // hence finding maximum Bob stone is equal to finding minimum alice stone
            int result = Integer.MAX_VALUE;
            for (int j = 0; j < Math.min(2 * M, piles.length - i); j++) {
                result = Math.min(result, dfsBF(0,i + j + 1, Math.max(M, j + 1), piles));
            }
            return result;
        } else {
            int result = 0;
            int sum = 0;
            for (int j = 0; j < Math.min(2 * M, piles.length - i); j++) {
                sum += piles[i + j];
                result = Math.max(result, dfsBF(1, i + j + 1, Math.max(M, j + 1), piles) + sum);
            }
            return result;
        }
    }
    public int stoneGameIIBottomUp(int[] piles) {
        int n = piles.length;
        int[] suffix = new int[n];
        suffix[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = piles[i] + suffix[i + 1];
        }

        int[][] dp = new int[n][n + 1];
        Arrays.fill(dp[n - 1], piles[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j <= n; j++) {
                for (int x = 1; x <= 2 * j; x++) {
                    if (i + x - 1 >= n - 1) {
                        dp[i][j] = Math.max(dp[i][j], suffix[i]);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], suffix[i] - dp[i + x][Math.max(j, x)]);
                    }
                }
            }
        }

        return dp[0][1];
    }
    public static void main(String[] args) {
        int[] piles = {2,7,9,4,4};
        StoneGameII stoneGameII = new StoneGameII();
        System.out.println(stoneGameII.stoneGameIIBottomUp(piles));
    }
}
