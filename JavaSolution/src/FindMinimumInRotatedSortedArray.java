public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        // perform binary search
        int left = 0;
        int right = nums.length - 1;
        // left & right
        while (left < right) {
            // mid
            int mid = (left + right) / 2;
            // go into the range if the range is not sorted
            if (nums[left] > nums[mid]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
            // else, it is a sorted array, which can be performed regular bs
        }

        // return result
        return nums[left];
    }
}
