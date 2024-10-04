import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> decreasingStack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            boolean findGreater = false;
            while (!decreasingStack.isEmpty() && !findGreater) {
                int index = decreasingStack.peek();
                if (nums[index] > nums[i]) {
                    result[i] = nums[index];
                    findGreater = true;
                } else {
                    decreasingStack.pop();
                }
            }
            if (!findGreater) {
                result[i] = -1;
            }
            decreasingStack.push(i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            boolean findGreater = false;
            while (!decreasingStack.isEmpty() && !findGreater) {
                int index = decreasingStack.peek();
                if (nums[index] > nums[i]) {
                    result[i] = nums[index];
                    findGreater = true;
                } else {
                    decreasingStack.pop();
                }
            }
            if (!findGreater) {
                result[i] = -1;
            }
            decreasingStack.push(i);
        }

        return result;
    }
    public int[] nextGreaterElementsForward(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        Arrays.fill(result, -1);

        for (int i = 0; i < 2 * nums.length; i++) {
            int index = i % nums.length;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                int destIndex = stack.pop();
                result[destIndex] = nums[index];
            }
            stack.push(index);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        NextGreaterElementII nextGreaterElementII = new NextGreaterElementII();
        System.out.println(nextGreaterElementII.nextGreaterElementsForward(nums));
    }

}
