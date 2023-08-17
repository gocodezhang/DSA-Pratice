public class JumpGameII {
    public static int minJump(int[] nums) {
        int steps = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length - 1) {
            int farthestPos = 0;
            for (int i = left; i <= right; i++) {
                farthestPos = Math.max(farthestPos, i + nums[i]);
            }
            left = right + 1;
            right = farthestPos;
            steps += 1;
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(minJump(nums));
    }
}
