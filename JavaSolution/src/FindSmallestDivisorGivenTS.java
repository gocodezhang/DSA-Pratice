public class FindSmallestDivisorGivenTS {
    public int smallestDivisor(int[] nums, int threshold) {
        // define the range
        int left = 1;
        int right = 1;
        for (int i = 0; i < nums.length; i++) {
            right = Math.max(right, nums[i]);
        }

        while (left < right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += Math.ceil((double) nums[i] / mid);
            }
            if (sum > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
