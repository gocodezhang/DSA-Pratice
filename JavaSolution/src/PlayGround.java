import javax.swing.*;
import java.util.*;

public class PlayGround {
    public int jumpWithDfs(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(0, nums, memo);
    }
    private int dfs(int currPosition, int[] nums, int[] memo) {
        // base case
        if (currPosition == nums.length - 1) {
            return 0;
        }
        if (memo[currPosition] != -1) {
            return memo[currPosition];
        }

        // recursive case
        int maxStep = Math.min(nums[currPosition], nums.length - 1 - currPosition);
        int minStepToDst = Integer.MAX_VALUE;
        for (int step = 1; step <= maxStep; step++) {
            minStepToDst = Math.min(dfs(currPosition + step, nums, memo), minStepToDst);
        }

        int result = minStepToDst == Integer.MAX_VALUE ? minStepToDst : minStepToDst + 1;
        memo[currPosition] = result;

        return result;
    }
    public int jumpWithDp(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[nums.length - 1] = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            int maxStep = Math.min(nums[i], nums.length - 1 - i);
            int min = Integer.MAX_VALUE;
            for (int step = 1; step <= maxStep; step++) {
                min = Math.min(min, dp[i + step]);
            }
            if (min < Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }

        return dp[0];
    }
    public int jumpWithRange(int[] nums) {
        // define a jump range
        int jumpStep = 0;
        int left = 0;
        int right = 0;
        // while the range cannot get to the dst
        while (right < nums.length - 1) {
            // go through curr range
            int furthest = right + 1;
            for (int i = left; i <= right; i++) {
                int rightMostIndex = Math.min(i + nums[i], nums.length - 1);
                furthest = Math.max(furthest, rightMostIndex);
            }
            // to find update range for next jump
            left = right + 1;
            right = furthest;
            // increase jump
            jumpStep++;
        }
        // return jump
        return jumpStep;
    }
    public int jumpWithRangeOptimal(int[] nums) {
        int currFurthest = 0;
        int nextFurthest = 0;
        int jumpStep = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            nextFurthest = Math.max(nextFurthest, i + nums[i]);

            if (i == currFurthest) {
                jumpStep++;
                currFurthest = nextFurthest;
            }
        }

        return jumpStep;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,0,1,4};
        PlayGround playGround = new PlayGround();
        System.out.println(playGround.jumpWithDp(nums));
    }
}
