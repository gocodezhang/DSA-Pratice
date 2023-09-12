public class PartitionEqualSubSet {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        Boolean[][] memo = new Boolean[nums.length][sum / 2];
        return dfs(0, 0,sum / 2, nums, memo);
    }
    public static boolean dfs(int currSum, int currPos, int target, int[] nums, Boolean[][] memo) {
        if (currSum >= target) {
            return currSum == target;
        }
        if (currPos >= nums.length) {
            return false;
        }
        if (memo[currPos][currSum] != null) {
            return memo[currPos][currSum];
        }
        boolean branch1 = dfs(currSum + nums[currPos], currPos + 1, target, nums, memo);
        boolean branch2 = dfs(currSum, currPos + 1, target, nums, memo);
        boolean result = branch1 || branch2;
        memo[currPos][currSum] = result;
        return result;
    }
    public static boolean canPartitionIterative(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] cpMatrix = new boolean[nums.length][target + 1];
        cpMatrix[0][0] = true;
        cpMatrix[0][nums[0]] = true;
        for (int row = 1; row < nums.length; row++) {
            for (int col = 0; col < target + 1; col++) {
                if (cpMatrix[row - 1][col]) {
                    cpMatrix[row][col] = true;
                    if (col + nums[row] > target) {
                        continue;
                    }
                    cpMatrix[row][col + nums[row]] = true;
                }
            }
        }
        return cpMatrix[nums.length - 1][target];
    }
    public static void main(String[] main) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartitionIterative(nums));
    }
}
