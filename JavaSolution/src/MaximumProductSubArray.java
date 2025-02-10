public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        // minSoFar, maxSoFar
        int minSoFar = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(minSoFar * curr, maxSoFar * curr));
            minSoFar = Math.min(curr, Math.min(minSoFar * curr, maxSoFar * curr));

            result = Math.max(result, tempMax);
            maxSoFar = tempMax;
        }

        return result;
    }
    public int maxProductDivideConquer(int[] nums) {
        return maxProductHelper(nums, 0, nums.length - 1);
    }
    public int maxProductHelper(int[] nums, int left, int right) {
        // base case
        if (left == right) {
            return nums[left];
        }

        // recursive case
        int mid = (left + right) / 2;
        int leftMax = maxProductHelper(nums, left, mid);
        int rightMax = maxProductHelper(nums, mid + 1, right);

        int currProduct = nums[mid];
        int maxProduct = nums[mid];
        int minProduct = nums[mid];
        for (int i = mid + 1; i <= right; i++) {
            int curr = nums[i];
            currProduct = currProduct * curr;
            maxProduct = Math.max(maxProduct, currProduct);
            minProduct = Math.min(minProduct, currProduct);
        }
        int result = maxProduct;
        for (int i = mid - 1; i >= left; i--) {
            int curr = nums[i];
            int tempMax = Math.max(curr * maxProduct, curr * minProduct);
            minProduct = Math.min(curr * maxProduct, curr * minProduct);

            maxProduct = tempMax;
            result = Math.max(result, maxProduct);
        }

        return Math.max(result, Math.max(leftMax, rightMax));
    }
    public static void main(String[] args) {
        MaximumProductSubArray ms = new MaximumProductSubArray();
        int[] nums = {2,-5,-2,-4,3};
        System.out.println(ms.maxProductDivideConquer(nums));
    }
}
