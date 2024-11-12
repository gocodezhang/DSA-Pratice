public class MinimumSwapsGroupAll1sII {
    public int minSwaps(int[] nums) {
        // find out the window size
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int[] prefix = new int[nums.length + sum ];
        int cumulativeSum = 0;
        for (int i = 0; i < nums.length + sum; i++) {
            prefix[i] = cumulativeSum;
            int index = i % nums.length;
            cumulativeSum += nums[index];
        }

        int max = 0;
        for (int i = sum; i < nums.length + sum; i++) {
            int windowSum = prefix[i] - prefix[i - sum];
            max = Math.max(max, windowSum);
        }

        return sum - max;
    }
    public int minSwapsSlidingWindow(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int left = 0;
        int right = 0;
        int currWindow = 0;
        int maxWindow = 0;

        while (right < nums.length + sum) {
            while (right - left < sum) {
                currWindow += nums[right % nums.length];
                right++;
            }
            maxWindow = Math.max(maxWindow, currWindow);

            while (right < nums.length + sum && right - left >= sum) {
                currWindow -= nums[left];
                left++;
            }
        }

        return sum - maxWindow;
    }
    public static void main(String[] main) {
        int[] nums = {0,1,0,1,0,0,1};
        MinimumSwapsGroupAll1sII minimumSwapsGroupAll1sII = new MinimumSwapsGroupAll1sII();
        System.out.println(minimumSwapsGroupAll1sII.minSwapsSlidingWindow(nums));
    }
}
