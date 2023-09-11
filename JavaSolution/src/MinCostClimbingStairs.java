import java.util.Arrays;

public class MinCostClimbingStairs {
    public static int minCostClimbing(int[] cost) {
        int[] memo = new int[cost.length + 1];
        Arrays.fill(memo, -1);
        return dfs(-1, memo, cost);
    }
    public static int dfs(int currStep, int[] memo, int[] cost) {
        // base case
        // if (i > top)
        if (currStep > cost.length) {
            return Integer.MAX_VALUE;
        }
        if (currStep == cost.length) {
            return 0;
        }
        // if (memo[i] != -1)
        if (memo[currStep + 1] != -1) {
            return memo[currStep + 1];
        }
        // recursive case
        // memo[i] = min(dfs(i + 1, memo, top, currCost), dfs(i + 2, memo, top, currCost))
        int currCost = currStep == -1 ? 0 : cost[currStep];
        int result = currCost + Math.min(dfs(currStep + 1, memo, cost), dfs(currStep + 2, memo, cost));
        memo[currStep + 1] = result;
        // return memo[i]
        return result;
    }
    public static int minCostClimbingIterative(int[] cost) {
        int[] miniCost = new int[cost.length + 1];
        miniCost[cost.length] = cost[cost.length - 1];
        miniCost[cost.length - 1] = cost[cost.length - 2];
        for (int i = cost.length - 2; i >=0; i--) {
            int stepCost = i > 0 ? cost[i - 1] : 0;
            miniCost[i] = stepCost + Math.min(miniCost[i + 1], miniCost[i + 2]);
        }
        return miniCost[0];
    }
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingIterative(cost));
    }
}
