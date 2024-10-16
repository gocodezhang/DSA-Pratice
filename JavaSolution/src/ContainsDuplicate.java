import java.util.HashMap;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int frequency = frequencyMap.getOrDefault(num, 0);
            if (frequency == 1) {
                return true;
            }
            frequencyMap.put(num, frequency + 1);
        }

        return false;
    }
}
