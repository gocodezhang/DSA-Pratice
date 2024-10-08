import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int count = 0;
        int prevElement = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int currElement = nums[i];

            int diff = prevElement - currElement;
            if (diff < 0) {
                prevElement = currElement;
            } else {
                count += diff + 1;
                prevElement = currElement + diff + 1;
            }

        }

        return count;
    }
}
