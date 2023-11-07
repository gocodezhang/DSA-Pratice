public class MinimumSizeArrSum {
    public static int minSubArrayLen(int target, int[] nums) {
        // create two pointers (left, right)
        int left = 0, right = 0;
        // create currSum = 0
        int currSum = 0;
        // create miniLength = max value
        int miniLength = Integer.MAX_VALUE;

        // while (left < nums.length)
        while (right < nums.length) {
            // currSum += nums[right]
            currSum += nums[right];
            // if (currSum >= target)
            while (currSum >= target) {
                miniLength = Math.min(right - left + 1, miniLength);
                currSum -= nums[left];
                left++;
            }
            right++;

        }

        // return miniLength == max value ? 0 : miniLength
        return miniLength == Integer.MAX_VALUE ? 0 : miniLength;
    }
    public static void main(String[] main) {
        int target = 80;
        int[] nums = {10,5,13,4,8,4,5,11,14,9,16,10,20,8};
        System.out.println(minSubArrayLen(target, nums));
    }

}
