import java.util.HashMap;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            int prevIndex = indexMap.getOrDefault(currNum, -1);
            if (prevIndex != -1 && (i - prevIndex) <= k) {
                return true;
            }
            indexMap.put(currNum, i);

        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();
        System.out.println(containsDuplicateII.containsNearbyDuplicate(nums, 2));
    }
}
