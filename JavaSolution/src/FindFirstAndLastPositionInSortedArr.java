public class FindFirstAndLastPositionInSortedArr {
    public int[] searchRange(int[] nums, int target) {
        int left = searchMinimumIndex(nums, target);
        int right = searchMaximumIndex(nums, target);

        return new int[]{left, right};

    }
    private int searchMinimumIndex(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left] == target ? left : -1;
    }
    private int searchMaximumIndex(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;


        while (left < right) {
            int mid = (left + right) / 2;
            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left == 0) {
            return -1;
        }

        return nums[left - 1] == target ? left - 1 : -1;
    }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        FindFirstAndLastPositionInSortedArr findFirstAndLastPositionInSortedArr = new FindFirstAndLastPositionInSortedArr();
        System.out.println(findFirstAndLastPositionInSortedArr.searchRange(nums, 8));
    }
}
