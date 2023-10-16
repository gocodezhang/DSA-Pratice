import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        // update k
        k = k % n;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int currIndex = start;
            int currValue = nums[start];
            do {
                int nextIndex = (currIndex + k) % n;
                int temp = nums[nextIndex];
                nums[nextIndex] = currValue;
                currValue = temp;
                currIndex = nextIndex;
                count++;
            } while (currIndex != start);
        }
    }
    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
