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

}
