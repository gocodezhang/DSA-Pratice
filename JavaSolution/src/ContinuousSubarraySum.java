import java.util.HashMap;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, - 1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int mod = prefixSum % k;
            if (map.containsKey(mod) && (i - map.get(mod)) >= 2) {
                return true;
            }
            if (!map.containsKey(mod)) {
                map.put(mod, i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {23,2,4,6,6};
        ContinuousSubarraySum continuousSubarraySum = new ContinuousSubarraySum();
        System.out.println(continuousSubarraySum.checkSubarraySum(nums, 7));
    }
}
