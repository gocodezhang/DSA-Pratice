import java.util.Arrays;

public class TargetSum {
    static int total;
    public static int findTargetSumWays(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int[][] dp = new int[nums.length][2*total + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0, target, dp, nums);
    }
    public static int dfs(int currIndex, int currSum, int target, int[][] dp, int[] nums) {
        // base case
        // if (i >= nums.length)
        if (currIndex == nums.length) {
            if (currSum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        // if (dp[i][remaining] != -1)
        if (dp[currIndex][currSum + total] != -1) {
            return dp[currIndex][currSum + total];
        }
        // recursive case
        // dfs(i + 1, remaining - nums[i])
        // dfs(i + 1, remaining + nums[i])
        int result = dfs(currIndex + 1, currSum - nums[currIndex], target, dp, nums)
                + dfs(currIndex + 1, currSum + nums[currIndex], target, dp, nums);

        // dp[i][remaining] = sum;
        dp[currIndex][currSum + total] = result;
        // return sum of two
        return result;
    }
    public static int findTargetSumWaysIterative(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < Math.abs(target)) {
            return 0;
        }
        int[][] dp = new int[nums.length][2*sum + 1];
        dp[nums.length - 1][nums[nums.length - 1] + sum] = 1;
        dp[nums.length - 1][-nums[nums.length - 1] + sum] += 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 0; j < 2*sum + 1; j++) {
                int ways = 0;
                if (j - nums[i] >=0) {
                    ways += dp[i + 1][j - nums[i]];
                }
                if (j + nums[i] <= 2*sum) {
                    ways += dp[i + 1][j + nums[i]];
                }
                dp[i][j] = ways;
            }
        }
        return dp[0][target + sum];
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWaysIterative(nums, target));
    }
}
