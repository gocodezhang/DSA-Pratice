public class DecreaseElementsMakeZigzag {
    public int moveToMakeZigzag(int[] nums) {
        int n = nums.length;
        // try make even index
        int countEven = 0;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < n; i += 2) {
            int left = prev;
            int right = i + 1 < n ? nums[i + 1] : Integer.MIN_VALUE;
            int curr = nums[i];

            int move = 0;
            if (left >= curr) {
                move += left - (curr - 1);
            }
            int decrease = 0;
            if (right >= curr) {
                move += right - (curr - 1);
                decrease += right - (curr - 1);
            }
            prev = right - decrease;
            countEven += move;
        }
        // try make old index
        int countOld = 0;
        prev = nums[0];
        for (int i = 1; i < n; i += 2) {
            int left = prev;
            int right = i + 1 < n ? nums[i + 1] : Integer.MIN_VALUE;
            int curr = nums[i];

            int move = 0;
            if (left >= curr) {
                move += left - (curr - 1);
            }
            int decrease = 0;
            if (right >= curr) {
                move += right - (curr - 1);
                decrease += right - (curr - 1);
            }
            prev = right - decrease;
            countOld += move;
        }
        // return the smaller one
        return Math.min(countEven, countOld);
    }
//    public int dfsEven(int prevValue, int currIndex, int[] nums) {
//        // base case
//        if (currIndex >= nums.length) {
//            return 0;
//        }
//
//        // recursive case
//
//        int left = prevValue;
//        int right = currIndex + 1 < nums.length ? nums[currIndex + 1] : Integer.MIN_VALUE;
//        int curr = nums[currIndex];
//        // increase even index
//        int max = Math.max(left, right);
//        int increase = curr > max ? 0 : max + 1 - curr;
//        int option1 =  increase + dfsEven(right, currIndex + 2, nums);
//        // decrease adj index
//        int decreaseLeft = left < curr ? 0 : left - (curr - 1);
//        int decreaseRight = right < curr ? 0 : right - (curr - 1);
//
//        int option2 = decreaseLeft + decreaseRight + dfsEven(right - decreaseRight,currIndex + 2, nums);
//
//        return Math.min(option1, option2);
//
//    }
    public static void main(String[] args) {
        int[] nums = {3,6,3};
        DecreaseElementsMakeZigzag decreaseElementsMakeZigzag = new DecreaseElementsMakeZigzag();
        System.out.println(decreaseElementsMakeZigzag.moveToMakeZigzag(nums));
    }
}
