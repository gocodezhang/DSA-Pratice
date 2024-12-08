public class MinimumOperationsReduceX {
    public int minOperations(int[] nums, int x) {
        // find the total
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        // targetSum = total - x
        int target = total - x;

        if (target <= 0) {
            return target == 0 ? n : -1;
        }

        // find the largest window whose sum = targetSum
        int size = 0;
        int left = 0;
        int right = 0;
        int windowSum = 0;

        while (right < n) {
            while (windowSum < target && right < n) {
                windowSum = windowSum + nums[right];
                right++;
                if (windowSum == target) {
                    size = Math.max(size, right - left);
                }
            }
            while (left < right && windowSum >= target) {
                windowSum = windowSum - nums[left];
                left++;
                if (windowSum == target) {
                    size = Math.max(size, right - left);
                }
            }

        }

        // return n - windowSize
        return size == 0 ? -1 : n - size;
    }
    public int minOperationsForLoop(int[] nums, int x) {
        int n = nums.length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            total += nums[i];
        }

        int target = total - x;

        if (target <= 0) {
            return target == 0 ? n : -1;
        }

        int left = 0;
        int windowSum = 0;
        int size = 0;

        for (int right = 0; right < n; right++) {
            windowSum += nums[right];

            while (left <= right && windowSum > target) {
                windowSum -= nums[left];
                left++;
            }

            if (windowSum == target) {
                size = Math.max(size, right - left + 1);
            }
        }

        return size == 0 ? -1 : n - size;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,4,2,3};
        MinimumOperationsReduceX minimumOperationsReduceX = new MinimumOperationsReduceX();
        System.out.println(minimumOperationsReduceX.minOperationsForLoop(nums, 5));
    }

}
