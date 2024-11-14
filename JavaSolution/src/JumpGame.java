import java.util.Stack;

public class JumpGame {
    public boolean canJumpWithDFS(int[] nums) {
        Boolean[] memo = new Boolean[nums.length];
        return dfs(0, nums, memo);
    }
    private boolean dfs(int i, int[] nums, Boolean[] memo) {
        // base case
        if (i == nums.length - 1) {
            return true;
        }
        if (memo[i] != null) {
            return memo[i];
        }


        // recursive case
        int maxStep = nums[i];
        for (int step = 1; step <= maxStep; step++) {
            if (i + step <= nums.length - 1 && dfs(i + step, nums, memo)) {
                memo[i] = true;
                return true;
            }
        }

        memo[i] = false;

        return false;
    }
    public boolean canJumpWithDP(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            int maxStep = Math.min(nums[i], nums.length - 1 - i);
            for (int step = 1; step <= maxStep; step++) {
                if (dp[i + step]) {
                    dp[i] = true;
                }
            }
        }

        return dp[0];
    }
    public boolean canJumpWithStack(int[] nums) {
        // use stack to find all 0s from right to left
        Stack<Integer> gaps = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0 && i != nums.length - 1) {
                gaps.push(i);
            }
        }
        // go through nums
        for (int i = 0; i < nums.length; i++) {
            // nums[i] != 0 && i < gap index && i + nums[i] > gap index
            while (nums[i] != 0 && !gaps.isEmpty() && i < gaps.peek() && i + nums[i] > gaps.peek()) {
                gaps.pop();
            }
        }
        // check if stack is empty
        return gaps.isEmpty();
    }
    public boolean canJumpWithGreedy(int[] nums) {
        int leftMostGoodIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= leftMostGoodIndex) {
                leftMostGoodIndex = i;
            }
        }

        return leftMostGoodIndex == 0;
    }
}
