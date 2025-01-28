import java.util.Arrays;

public class SmallestRangeII {
    public int smallestRangeII(int[] nums, int k) {
        // sort nums
        Arrays.sort(nums);
        // max, min
        int answer = nums[nums.length - 1] - nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            int high = Math.max(nums[nums.length - 1] - k, nums[i] + k);
            int low = Math.min(nums[0] + k, nums[i + 1] - k);
            answer = Math.min(answer, high - low);
        }

        return answer;
    }
}
