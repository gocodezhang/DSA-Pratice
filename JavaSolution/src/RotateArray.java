import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
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

    public void rotateUsingExtraArray(int[] nums, int k) {
        int actualK = k % nums.length;
        int[] temp = new int[nums.length];

        int newHead = nums.length - actualK;
        int oldHead = 0;

        for (int i = 0; i < temp.length; i++) {
            if (newHead < temp.length) {
                temp[i] = nums[newHead];
                newHead++;
            } else {
                temp[i] = nums[oldHead];
                oldHead++;
            }
        }

        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }
    public void rotateKTimes(int[] nums, int k) {
        int actualK = k % nums.length;

        for (int i = 0; i < actualK; i++) {
            int prev = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }
    public void rotateWithReverse(int[] nums, int k) {
        int actualK = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, actualK - 1);
        reverse(nums, actualK, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int k = 2;
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
