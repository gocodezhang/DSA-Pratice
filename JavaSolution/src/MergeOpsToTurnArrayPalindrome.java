public class MergeOpsToTurnArrayPalindrome {
    public int minimumOperations(int[] nums) {
        // two pointers (left, right)
        int countMerge = 0;
        int left = 0;
        int right = nums.length - 1;
        int leftNum = nums[left];
        int rightNum = nums[right];
        // while two pointers has not merge
        while (left < right) {
            // compare left with right
            // 1. left == right, move both pointers towards middle
            if (leftNum == rightNum) {
                left++;
                right--;
                leftNum = nums[left];
                rightNum = nums[right];
            } else if (leftNum < rightNum) {
                left++;
                leftNum += nums[left];
                countMerge++;
            } else {
                right--;
                rightNum += nums[right];
                countMerge++;
            }
        }

        // return number of merge
        return countMerge;
    }
    public static void main(String[] args) {
        int[] nums = {1,2};
        MergeOpsToTurnArrayPalindrome mp = new MergeOpsToTurnArrayPalindrome();
        System.out.println(mp.minimumOperations(nums));
    }

}
