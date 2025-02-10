import javax.swing.*;
import java.util.*;

public class PlayGround {
    public int maxSubarray(int[] nums) {
        // currSum
        int currSum = 0;
        // globalMaxSum
        int globalMaxSum = Integer.MIN_VALUE;
        // go through nums
        for (int i = 0; i < nums.length; i++) {
            // check if currSum < 0 - when true, reset 0
            currSum = Math.max(0, currSum);
            // add num into currSum
            currSum += nums[i];
            // try update globalMax
            globalMaxSum = Math.max(globalMaxSum, currSum);
        }

        // return globalMax
        return globalMaxSum;
    }



    public static void main(String[] args) {
        PlayGround playground = new PlayGround();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(playground.maxSubarray(nums));
    }

}
