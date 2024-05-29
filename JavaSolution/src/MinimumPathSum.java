import java.util.Arrays;

public class MinimumPathSum {
    public int miniPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dfs(0, 0, grid, memo);
    }
    public int dfs(int i, int j, int[][] grid, int[][] memo) {
        // base case
        int m = memo.length;
        int n = memo[0].length;
        // if (i == m - 1 && j = n - 1)
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }
        // if (memo[i][j] != -1)
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // recursive case
        int left = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
        if (i + 1 <= m - 1) {
            down = dfs(i + 1, j, grid, memo);
        }

        if (j + 1 <= n - 1) {
            left = dfs(i, j + 1, grid, memo);
        }
        int result = grid[i][j] + Math.min(left, down);
        // memo[i][j] = result
        memo[i][j] = result;
        // return result
        return result;
    }
    public int miniPathSumIterative(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = grid[i][n - 1] + dp[i + 1][n - 1];
        }
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = grid[m - 1][j] + dp[m - 1][j + 1];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        return dp[0][0];
    }
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        System.out.println(minimumPathSum.miniPathSum(grid));
        System.out.println(minimumPathSum.miniPathSumIterative(grid));
    }
}
