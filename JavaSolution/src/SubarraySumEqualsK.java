import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subArraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
    public int subArraySumOnePass(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0;

        prefixSumMap.put(sum, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (prefixSumMap.containsKey(sum - k)) {
                count += prefixSumMap.get(sum - k);
            }
            if (!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum, 0);
            }
            prefixSumMap.put(sum, prefixSumMap.get(sum) + 1);
        }
        return count;
    }

}
