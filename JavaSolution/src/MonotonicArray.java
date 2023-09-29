public class MonotonicArray {
    public static boolean isMonotonic(int[] nums) {
        // check if array has only one
        if (nums.length == 1) {
            return true;
        }
        // create type = 0;
        int type = 0;
        // traverse from the second element
        for (int i = 1; i < nums.length; i++) {
            // compare prevElement with the currElement
            int prevElement = nums[i - 1];
            int currElement = nums[i];
            // if (prevElement > currElement)
            if (prevElement > currElement) {
                // if (type == 1)
                if (type == 1) {
                    return false;
                }
                // type = -1
                type = -1;
            } else if (prevElement < currElement) {
                // if (type == -1)
                if (type == -1) {
                    return false;
                }
                // type = 1
                type = 1;
            }
        }

        // return true
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {6,5,5,6};
        System.out.println(isMonotonic(nums));
    }
}
