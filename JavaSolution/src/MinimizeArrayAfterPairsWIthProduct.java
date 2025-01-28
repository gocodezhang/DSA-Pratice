public class MinimizeArrayAfterPairsWIthProduct {
    public int minArrayLength(int[] nums, int k) {
        // curr, merge
        int prev = nums[0];
        int merge = 0;
        // go from left to right
        for (int i = 1; i < nums.length; i++) {
            // try merge
            int curr = nums[i];
            if (prev * curr <= k) {
                merge++;
                prev = prev * curr;
            } else {
                prev = curr;
            }
        }

        return nums.length - merge;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,3,7,3,5};
        MinimizeArrayAfterPairsWIthProduct mr = new MinimizeArrayAfterPairsWIthProduct();
        System.out.println(mr.minArrayLength(nums, 20));
    }
}
