public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // find first element that is smaller
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            reverse(0, nums);
            return;
        }
        // swap with the element just larger than it
        int j = nums.length - 1;
        while (nums[i] >= nums[j]) {
            j--;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        // reverse
        reverse(i + 1, nums);
    }
    public void reverse(int start, int[] nums) {
        int end = nums.length - 1;

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
