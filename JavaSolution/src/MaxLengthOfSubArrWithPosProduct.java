public class MaxLengthOfSubArrWithPosProduct {
    public static int getMaxLen(int[] nums) {
        int maxLength = 0;
        int currPos = 0;
        int currNeg = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                currPos = 0;
                currNeg = 0;
            } else if (nums[i] > 0) {
                if (currNeg > 0) {
                    currNeg++;
                }
                currPos++;
            } else {
                int temp = currPos;
                currPos = currNeg == 0 ? 0 : currNeg + 1;
                currNeg = temp == 0 ? 1 : temp + 1;
            }
            maxLength = Math.max(maxLength, currPos);
        }
        return maxLength;
    }
    public static void main(String[] main) {
        int[] nums = {1,-2,-3,-4};
        System.out.println(getMaxLen(nums));
    }
}
