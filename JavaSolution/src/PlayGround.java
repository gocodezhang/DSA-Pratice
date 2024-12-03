import javax.swing.*;
import java.util.*;

public class PlayGround {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int product = 1;
        for (int i = 0; i < n; i++) {
            left[i] = product;
            product = product * nums[i];
        }
        int[] right = new int[n];
        product = 1;
        for (int i = n - 1; i >=0; i--) {
            right[i] = product;
            product = product * nums[i];
        }
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }
    public int[] produceExceptSelfConstantSpace(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int product = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = product;
            product = product * nums[i];
        }
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * product;
            product = product * nums[i];
        }
        return answer;
    }


    public static void main(String[] args) {
        PlayGround playground = new PlayGround();
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(playground.productExceptSelf(nums)));

    }
}
