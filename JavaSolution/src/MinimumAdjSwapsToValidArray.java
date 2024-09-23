public class MinimumAdjSwapsToValidArray {
    public int minimumSwaps(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            int currNum = nums[i];
            if (currNum >= max) {
                maxIndex = i;
                max = currNum;
            }
            if (currNum < min) {
                minIndex = i;
                min = currNum;
            }
        }

        if (maxIndex == minIndex) {
            return 0;
        }
        int result = (nums.length - 1 - maxIndex) + (minIndex);
        if (maxIndex < minIndex) {
            result--;
        }
        return result;
    }
}
