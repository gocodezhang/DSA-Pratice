public class ContainMostWater {
    public int maxArea(int[] height) {
        // left = 0; right = length - 1;
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int leftLine = height[left];
            int rightLine = height[right];
            maxArea = Math.max(maxArea, Math.min(leftLine, rightLine) * (right - left));
            if (leftLine < rightLine) {
                left++;
            } else {
                right--;
            }
        }
        // min(height[left], height[right]) x (right - left)
        return maxArea;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainMostWater containMostWater = new ContainMostWater();
        System.out.println(containMostWater.maxArea(height));
    }
}
