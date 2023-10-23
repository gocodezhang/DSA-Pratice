import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        int i = 1;
        int count = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j - 1] == nums[j]) {
                count++;
            } else {
                count = 1;
            }

            if (count >= 3) {
                continue;
            }
            nums[i] = nums[j];
            i++;
        }
        return i;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
