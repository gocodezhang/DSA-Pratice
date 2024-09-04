import java.util.*;

public class PlayGround {
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        PlayGround playGround = new PlayGround();
        System.out.println(playGround.binarySearch(nums,2));
    }
}
