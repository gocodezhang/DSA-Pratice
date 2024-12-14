import javax.swing.*;
import java.util.*;

public class PlayGround {

    public int trapBF(int[] height) {
        int n = height.length;
        int amount = 0;

        for (int i = 1; i < n - 1; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) {
                left = Math.max(left, height[j]);
            }
            for (int j = i + 1; j < n; j++) {
                right = Math.max(right, height[j]);
            }
            int bound = Math.min(left, right);
            amount += Math.max(bound - height[i], 0);
        }
        return amount;
    }
    public int trapWithExtraArray(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];

        for (int i = 1; i < n - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        int[] rightMax = new int[n];
        for (int i = n - 2; i >= 1; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        int amount = 0;
        for (int i = 1; i < n - 1; i++) {
            int bound = Math.min(leftMax[i], rightMax[i]);
            amount += Math.max(bound - height[i], 0);
        }

        return amount;
    }
    public int trapWithStack(int[] height) {
        int amount = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int popIndex = stack.pop();
                if (!stack.isEmpty()) {
                    int leftIndex = stack.peek();
                    int bound = Math.min(height[i], height[leftIndex]);
                    amount += (i - leftIndex - 1) * (bound - height[popIndex]);
                }
            }
            stack.add(i);
        }
        return amount;
    }
    public int trapWithTwoPointers(int[] height) {
        int amount = 0;
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            int bound = Math.min(leftMax, rightMax);
            if (leftMax < rightMax) {
                amount += Math.max(bound - height[left], 0);
                left++;
            } else {
                amount += Math.max(bound - height[right], 0);
                right--;
            }
        }

        return amount;
    }



    public static void main(String[] args) {
        PlayGround playground = new PlayGround();
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(playground.trapWithTwoPointers(nums));

    }
}
