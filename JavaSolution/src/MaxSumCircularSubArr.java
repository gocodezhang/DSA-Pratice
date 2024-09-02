public class MaxSumCircularSubArr {
    public int maxSubArraySumCircular(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];
        int suffixSum = nums[n - 1];
        rightMax[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixSum += nums[i];
            rightMax[i] = Math.max(rightMax[i + 1], suffixSum);
        }

        int globalMax = Integer.MIN_VALUE;
        int currSum = 0;
        int prefix = 0;
        for (int i = 0; i < n; i++) {
            currSum = Math.max(0, currSum) + nums[i];
            globalMax = Math.max(globalMax, currSum);

            if (i + 1 < n) {
                prefix += nums[i];
                globalMax = Math.max(globalMax, prefix + rightMax[i + 1]);
            }

        }
        return globalMax;
    }
    public static void main(String[] args) {
        int[] nums = {5, -3,5};
        MaxSumCircularSubArr maxSumCircularSubArr = new MaxSumCircularSubArr();
        System.out.println(maxSumCircularSubArr.maxSubArraySumCircular(nums));
    }
}
