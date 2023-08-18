import java.util.Arrays;

public class ClimbStairs {
    public static int WaysOfClimbing(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(0, n, memo);
    }

    public static int dfs(int currPos, int dist, int[] memo) {
        if (currPos == dist) {
            return 1;
        }
        if (currPos > dist) {
            return 0;
        }
        if (memo[currPos] != -1) {
            return memo[currPos];
        }

        int result = dfs(currPos + 1, dist, memo) + dfs(currPos + 2, dist, memo);
        memo[currPos] = result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(WaysOfClimbing(3));
    }
}
