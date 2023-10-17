import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class twoSum {
    public static int[] twoSumHashMap(int[] nums, int target) {
        // Build a hashmap
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indexArr = indexMap.getOrDefault(nums[i], new ArrayList<>());
            indexArr.add(i);
            indexMap.put(nums[i], indexArr);
        }
        // Iterate through the arrays
        for (int i = 0; i < nums.length; i++) {
            // otherKey = target - nums[i]
            int otherKey = target - nums[i];
            // check if the otherKey exist
            if (indexMap.containsKey(otherKey) && otherKey != nums[i]) {
                List<Integer> indexArr = indexMap.get(otherKey);
                return new int[]{i, indexArr.get(0)};
            }
            if (indexMap.containsKey(otherKey) && otherKey == nums[i] && indexMap.get(otherKey).size() >= 2) {
                List<Integer> indexArr = indexMap.get(otherKey);
                return new int[]{i, indexArr.get(1)};
            }
        }
        return new int[2];
    }
}
