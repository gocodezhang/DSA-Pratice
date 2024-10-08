import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallest {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 4;

        int minDiff = Integer.MAX_VALUE;
        while (left < 4) {
            minDiff = Math.min(minDiff, nums[right] - nums[left]);
            left++;
            right++;
        }

        return minDiff;
    }
}
