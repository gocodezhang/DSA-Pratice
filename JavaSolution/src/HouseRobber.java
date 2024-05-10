import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(0, nums, memo);
    }
    public int dfs(int index, int[] nums, int[] memo) {
        // base case
        // if (index >= nums.length)
        if (index >= nums.length) {
            return 0;
        }
        // if (index == nums.length -1)
        if (index == nums.length - 1) {
            return nums[index];
        }
        // if (memo[index] != -1)
        if (memo[index] != -1) {
            return memo[index];
        }

        // recursive
        int robCurrent = nums[index] + dfs(index + 2, nums, memo);
        int skipCurrent = dfs(index + 1, nums, memo);
        memo[index] = Math.max(robCurrent, skipCurrent);
        // return result
        return memo[index];
    }
    public int robIterative(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(nums));
        System.out.println(houseRobber.robIterative(nums));
    }
}
