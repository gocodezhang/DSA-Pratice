import java.util.ArrayList;
import java.util.List;

public class NumberOfSubArraysWithBoundedMax {
    public int numSubarrayBoundedMaxBF(int[] nums, int left, int right) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int currMax = 0;
            for (int j = i; j < nums.length; j++) {
                currMax = Math.max(currMax, nums[j]);
                if (currMax <= right && currMax >= left) {
                    count++;
                }
            }
        }
        return count;
    }
    public int numSubarrayBoundedMaxSlidingWindow(int[] nums, int left, int right) {
        int totalCount = 0;
        // left, right
        int start = 0;
        int end = 0;
        int currCount = 0;
        // while right < n
        while (start < nums.length && end < nums.length) {
            if (nums[end] >= left && nums[end] <= right) {
                // case 1 - encounter a num in range: curr window would be valid subarrays
                totalCount += end - start + 1;
                currCount += end - start + 1;
            } else if (nums[end] < left) {
                // case 2 - encounter a num is smaller: number of valid subarrays + this element would make a new set of valid subarrays
                totalCount += currCount;
            } else {
                // case 3 - encounter a num is larger: reset
                start = end + 1;
                currCount = 0;
            }
            end++;
        }
        return totalCount;
    }
    public int numSubarrayBoundedMaxComplementEvent(int[] nums, int left, int right) {
        // build a helper to count # subarrays <= k
        // result = events(<= right) - events(<= left - 1)
        return countSubarray(nums, right) - countSubarray(nums, left - 1);
    }
    public int countSubarray(int[] nums, int target) {
        long count = 0;
        long currLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                currLen++;
            } else {
                count += currLen * (currLen + 1) / 2;
                currLen = 0;
            }
        }
        return (int) (count + currLen * (currLen + 1) / 2);
    }
    public static void main(String[] args) {
        NumberOfSubArraysWithBoundedMax nm = new NumberOfSubArraysWithBoundedMax();
        int[] nums = {2,9,2,5,6};
        System.out.println(nm.numSubarrayBoundedMaxSlidingWindow(nums, 2, 8));
    }

}
