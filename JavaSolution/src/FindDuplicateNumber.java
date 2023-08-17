public class FindDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        if (nums.length == 2) {
            return nums[0];
        }
        // create two pointers: slow, fast
        int slow = nums[nums[0]];
        int fast = nums[nums[nums[0]]];
        // traverse the linked lists until two pointers meet
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // move the fast back to origin and traverse in normal speed
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // return where they meet again
        return slow;

    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate(nums));
    }
}
