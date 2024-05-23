import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }

        return dfs(0,0,triangle, memo);
    }
    public int dfs(int i, int j, List<List<Integer>> triangle, int[][] memo) {
        // base case
        // if (i >= n - 1)
        if (i > memo.length - 1) {
            return 0;
        }
        // if (memo[i, j] != max)
        if (memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }


        // recursive case
        // for (element in triangle(i + 1))
        int left = triangle.get(i).get(j) + dfs(i + 1, j, triangle, memo);
        int right = triangle.get(i).get(j) + dfs(i + 1, j + 1, triangle, memo);

        memo[i][j] = Math.min(left, right);
        return memo[i][j];
    }
    public int minimumTotalIterative(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        List<Integer> lastRow = triangle.get(n - 1);
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = lastRow.get(i);
        }
        for (int row = n - 2; row >= 0; row--) {
            List<Integer> currRow = triangle.get(row);
            for (int j = 0; j < currRow.size(); j++) {
                dp[row][j] = currRow.get(j) + Math.min(dp[row + 1][j], dp[row + 1][j + 1]);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        List<List<Integer>> triangle = List.of(List.of(2), List.of(3,4), List.of(6,5,7), List.of(4,1,8,3));
        Triangle triangle1 = new Triangle();
        System.out.println(triangle1.minimumTotalIterative(triangle));
    }
}
