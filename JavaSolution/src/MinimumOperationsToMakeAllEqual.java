import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumOperationsToMakeAllEqual {
    public List<Long> minOperations(int[] nums, int[] queries) {
        // sort the nums array
        Arrays.sort(nums);
        // create prefix
        long prefixSum = 0;
        long[] prefixSums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            prefixSums[i + 1] = prefixSum;
        }

        List<Long> result = new ArrayList<>();
        // iterate through queries
        for (int i = 0; i < queries.length; i++) {
            // perform binary search
            int currQuery = queries[i];
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < currQuery) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            long addOperations = (long) (left) * currQuery - prefixSums[left];
            long minusOperations = (prefixSums[nums.length] - prefixSums[left]) - (long) (nums.length - left) * currQuery;
            result.add(addOperations + minusOperations);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2,9,6,3};
        int[] queries = {10};
        MinimumOperationsToMakeAllEqual minimumOperationsToMakeAllEqual = new MinimumOperationsToMakeAllEqual();
        System.out.println(minimumOperationsToMakeAllEqual.minOperations(nums, queries));
    }
}
