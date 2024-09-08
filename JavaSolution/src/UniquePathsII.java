import java.util.Arrays;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int length = obstacleGrid[0].length;
        int[][] memo = new int[height][length];

        for (int i = 0; i < height; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0, obstacleGrid, memo);
    }
    public int dfs(int i, int j, int[][] obstacleGrid, int[][] memo) {
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        // base case
        // 1. when we get to 1
        // 2. out of bound
        // when either 1 or 2 is met, return 0
        if ((i < 0 || i >= rows) || (j < 0 || j >= columns) || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == rows - 1 && j == columns - 1) {
            return 1;
        }
        // when memo[i][j] != -1, return memo[i][j]
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // recursive case
        int[][] directions = {{1, 0}, {0, 1}};
        // try all direction
        int sum = 0;
        for (int[] direction : directions) {
            // memo[i][j] = answer
            // return dfs(go down) + dfs(go right)
            sum += dfs(i + direction[0], j + direction[1], obstacleGrid, memo);
        }

        memo[i][j] = sum;
        return sum;
    }
    public int uniquePathsWithObstaclesBottomUp(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] dp = new int[rows][columns];
        if (obstacleGrid[rows - 1][columns - 1] == 0) {
            dp[rows - 1][columns - 1] = 1;
        }

        for (int i = rows - 2; i >= 0; i--) {
            if (obstacleGrid[i][columns - 1] == 0) {
                dp[i][columns - 1] = dp[i + 1][columns - 1];
            }
        }
        for (int i = columns - 2; i >= 0; i--) {
            if (obstacleGrid[rows - 1][i] == 0) {
                dp[rows - 1][i] = dp[rows - 1][i + 1];
            }
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = columns - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,0},
                {0,1,0},
                {0,0,0},
        };
        UniquePathsII uniquePathsII = new UniquePathsII();
        System.out.println(uniquePathsII.uniquePathsWithObstaclesBottomUp(matrix));
    }
}
