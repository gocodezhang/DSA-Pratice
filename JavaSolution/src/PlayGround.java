import java.util.*;

public class PlayGround {
    public int[] minSubArray(int[] nums) {
        int minimumSum = Integer.MAX_VALUE;
        int currSum = 0;
        int left = 0;
        int[] index = new int[2];

        for (int right = 0; right < nums.length; right++) {
            if (currSum > 0) {
                currSum = 0;
                left = right;
            }
            currSum += nums[right];
            if (currSum < minimumSum) {
                minimumSum = currSum;
                index = new int[]{left, right + 1};
            }
        }
        return Arrays.copyOfRange(nums, index[0], index[1]);
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,-2,1,-5,4};
        PlayGround playGround = new PlayGround();
        System.out.println(playGround.minSubArray(nums));
    }
}
