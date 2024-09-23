import java.util.HashMap;

public class MaximumGoodSubArraySum {
    public long maximumSubarraySum(int[] nums, int k) {
        long max = Integer.MIN_VALUE;
        boolean hasGoodSub = false;

        for (int i = 0; i < nums.length; i++) {
            long currSum = 0;
            for (int j = i; j < nums.length; j++) {
                currSum += nums[j];
                if (Math.abs(nums[i] - nums[j]) == k) {
                    hasGoodSub = true;
                    max = Math.max(max, currSum);
                }
            }
        }

        return hasGoodSub ? max : 0;
    }
    public long maximumSubarraySumOptimal(int[] nums, int k) {
        long result = Long.MIN_VALUE;
        HashMap<Integer, Long> numberToPrefixSum = new HashMap<>();

        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (numberToPrefixSum.containsKey(nums[i] + k)) {
                long prefix = numberToPrefixSum.get(nums[i] + k);
                result = Math.max(result, sum - prefix + nums[i] + k);
            }

            if (numberToPrefixSum.containsKey(nums[i] - k)) {
                long prefix = numberToPrefixSum.get(nums[i] - k);
                result = Math.max(result, sum - prefix + nums[i] - k);
            }
            long prefixCurr = numberToPrefixSum.getOrDefault(nums[i], Long.MAX_VALUE);
            numberToPrefixSum.put(nums[i], Math.min(sum, prefixCurr));
        }

        return result == Long.MIN_VALUE ? 0 : result;
    }
}
