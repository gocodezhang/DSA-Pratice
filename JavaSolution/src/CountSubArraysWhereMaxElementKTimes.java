public class CountSubArraysWhereMaxElementKTimes {
    public long countSubArrays(int[] nums, int k) {
        int count = 0;
        // find the max
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        // using two loops to find all possible subarrays
        for (int i = 0; i < nums.length; i++) {
            int countMax = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == maxNum) {
                    countMax++;
                }
                if (countMax >= k) {
                    count++;
                }
            }
        }

        // return count
        return count;
    }
    public long countSubArraysSlidingWindow(int[] nums, int k) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        long result = 0;
        int left = 0;
        int countMax = 0;

        for (int right = 0; right < nums.length; right++) {
             int curr = nums[right];
             if (curr == maxNum) {
                 countMax++;
             }
             while (countMax >= k) {
                 if (nums[left] == maxNum) {
                     countMax--;
                 }
                 left++;
             }
             result += left;
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,3};
        CountSubArraysWhereMaxElementKTimes cm = new CountSubArraysWhereMaxElementKTimes();
        System.out.println(cm.countSubArrays(nums, 2));
    }
}
