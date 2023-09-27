public class TrappingRainWater {
    public static int trap(int[] height) {
        // Build the maxLeft array
        int[] maxLeftArr = new int[height.length];
        int maxLeft = 0;
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                maxLeftArr[i] = maxLeft;
                continue;
            }
            if (maxLeft < height[i - 1]) {
                maxLeft = height[i - 1];
            }
            maxLeftArr[i] = maxLeft;
        }
        // Build the maxRight array
        int[] maxRightArr = new int[height.length];
        int maxRight = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                maxRightArr[i] = maxRight;
                continue;
            }
            if (maxRight < height[i + 1]) {
                maxRight = height[i + 1];
            }
            maxRightArr[i] = maxRight;
        }
        // Iterate through height
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            int min = Math.min(maxLeftArr[i], maxRightArr[i]);
            int amount = min - height[i] >= 0 ? min - height[i] : 0;
            total += amount;
        }
        return total;
    }
    public static int trapTwoPointers(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int total = 0;
        while (left <= right) {
            if (maxLeft < maxRight) {
                total += Math.max(maxLeft - height[left], 0);
                maxLeft = Math.max(maxLeft, height[left]);
                left++;
            } else {
                total += Math.max(maxRight - height[right], 0);
                maxRight = Math.max(maxRight, height[right]);
                right--;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapTwoPointers(height));
    }
}
