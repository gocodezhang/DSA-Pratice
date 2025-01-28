public class SmallestRangeI {
    public int smallestRange(int[] nums, int k) {
        // find max and min
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return Math.max(max - min - 2 * k, 0);
    }
}
