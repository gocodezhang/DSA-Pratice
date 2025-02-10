public class SearchInRotatedSortedArray {
    public int searchOnePass(int[] nums, int target) {
        // binary search
        int left = 0;
        int right = nums.length - 1;
        // left & right
        while (left <= right) {
            int mid = (left + right) / 2;
            // 1. sort break - for broken range, check (left > target && mid < target)
            if (nums[left] > nums[mid] && (nums[left] <= target || nums[mid] > target)) {
                right = mid - 1;
            } else if (nums[mid] > nums[right] && (nums[mid] < target || nums[right] >= target)) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            // 2. range sorted - do regular bs
        }

        return -1;

    }
    public int searchWithPivot(int[] nums, int target) {
        // find pivot index (smallest index)
        int pivot = findPivot(nums);
        // perform binary search on two ranges
        int temp = binarySearch(nums, 0, pivot - 1, target);

        if (temp != -1) {
            return temp;
        }
        return binarySearch(nums, pivot, nums.length - 1, target);

    }
    public int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
    public int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public int searchWithShiftedArray(int[] nums, int target) {
        int n = nums.length;
        // find pivot index
        int pivot = findPivot(nums);
        // perform search as if it is normal sorted array using shift translation
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[(mid + pivot) % n] == target) {
                return (mid + pivot) % n;
            } else if (nums[(mid + pivot) % n] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;

    }
}
