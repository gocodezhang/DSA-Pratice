public class MaximumSubArr {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (maxSum < currSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
    public int maxSubArrayDiffImplementation(int[] nums) {
        // currSum
        int currSum = 0;
        // globalMaxSum
        int globalMaxSum = Integer.MIN_VALUE;
        // go through nums
        for (int i = 0; i < nums.length; i++) {
            // check if currSum < 0 - when true, reset 0
            currSum = Math.max(0, currSum);
            // add num into currSum
            currSum += nums[i];
            // try update globalMax
            globalMaxSum = Math.max(globalMaxSum, currSum);
        }

        // return globalMax
        return globalMaxSum;
    }
    public int maxSubArrayDivideConquer(int[] nums) {
        return findMaxHelper(nums, 0, nums.length - 1);
    }
    public int findMaxHelper(int[] nums, int left, int right) {
        // base case - left = right
        if (left == right) {
            return nums[left];
        }

        // recursive case
        int mid = (left + right) / 2;
        // 1. find left max
        int leftMax = findMaxHelper(nums, left, mid);
        // 2. find right max
        int rightMax = findMaxHelper(nums, mid + 1, right);
        // 3. find combo max using middle
        int maxML = 0;
        int currSum = 0;
        for (int i = mid - 1; i >= left; i--) {
            currSum += nums[i];
            maxML = Math.max(maxML, currSum);
        }
        int maxMR = 0;
        currSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            currSum += nums[i];
            maxMR = Math.max(maxMR, currSum);
        }
        // return largest among the three options
        return Math.max(leftMax, Math.max(rightMax, nums[mid] + maxML + maxMR));
    }
    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        MaximumSubArr ms = new MaximumSubArr();
        System.out.println(ms.maxSubArrayDivideConquer(nums));
    }
}
