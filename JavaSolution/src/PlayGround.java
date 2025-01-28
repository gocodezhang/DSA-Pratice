import javax.swing.*;
import java.util.*;

public class PlayGround {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<String> added = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        // sort nums
        Arrays.sort(nums);
        // two loops (i, j)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // two pointers approach
                int left = j + 1;
                int right = nums.length - 1;
                // fourSum > target - decrease right
                // fourSum < target - increase left
                // fourSum = target - add the answer
                //then when we move pointers - move left until a different num
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        String code = nums[i] + "-" + nums[j] + "-" + nums[left] + "-" + nums[right];
                        if (!added.contains(code)) {
                            List<Integer> list = List.of(nums[i], nums[j], nums[left], nums[right]);
                            result.add(list);
                            added.add(code);
                        }

                        left++;
                        right--;
                    }
                }
            }
        }

        return result;



    }




    public static void main(String[] args) {
        PlayGround playground = new PlayGround();
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        System.out.println(playground.fourSum(nums, -2));
    }

}
