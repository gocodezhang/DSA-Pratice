import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityEle(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int frequency = frequencyMap.getOrDefault(nums[i], 0);
            frequency++;
            if (frequency > nums.length / 2) {
                return nums[i];
            }
            frequencyMap.put(nums[i], frequency);
        }
        return -1;
    }
    /**
     * boyer-moore voting algorithm
     * In case array (nums) doesn't guarantee to have a majority element
     * we will need to traverse the array one more time to verify if the candidate is actually majority element
     */
    public static int majorityEleOptimal(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count = (nums[i] == candidate) ? count + 1 : count - 1;
        }
        return candidate;
    }

}
