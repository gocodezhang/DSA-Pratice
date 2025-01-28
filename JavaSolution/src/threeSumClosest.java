import java.util.Arrays;

public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        // closet
        int closest = Integer.MAX_VALUE;
        // result
        int result = 0;
        // sort nums
        Arrays.sort(nums);
        // go through nums
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            // update target = target - num
            // two pointers
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                // if two sum > target
                // increase or decrease pointers
                int distance = Math.abs(target - (currNum + nums[left] + nums[right]));
//                System.out.println("i: " + i);
//                System.out.println("left: " + left);
//                System.out.println("right: " + right);
//                System.out.println("distance: " + distance);
                if (distance < closest) {
                    closest = distance;
                    result = currNum + nums[left] + nums[right];
                }
                // System.out.println(closest);

                if (target > (currNum + nums[left] + nums[right])) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        // return result
        return result;
    }
    public int threeSumClosestBS(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        // closest
        int closest = Integer.MAX_VALUE;
        // result
        int result = 0;
        // two for loops (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // perform binary search (j + 1, n - 1)
                int left = j + 1;
                int right = n - 1;
                while (left <= right) {
                    // try update result if diff < closest
                    int m = (left + right) / 2;
                    int sum = nums[i] + nums[j] + nums[m];
                    int distance = Math.abs(target - sum);
                    if (distance < closest) {
                        closest = distance;
                        result = sum;
                    }
                    if (sum < target) {
                        left = m + 1;
                    } else if (sum > target) {
                        right = m - 1;
                    } else {
                        return sum;
                    }
                }
            }
        }


        // return result
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {-84,92,26,19,-7,9,42,-51,8,30,-100,-13,-38};
        threeSumClosest ts = new threeSumClosest();
        System.out.println(ts.threeSumClosestBS(nums, 77));
    }
}
