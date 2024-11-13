import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaximumWidthRamp {
    public int maxWidthRampBruceForce(int[] nums) {
        int maxRamp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] <= nums[j]) {
                    maxRamp = Math.max(maxRamp, j - i);
                }
            }
        }

        return maxRamp;
    }
    public int maxWidthRampWithDecreasingStackAndBinarySearch(int[] nums) {
        int maxRamp = 0;
        // keep a decrease stack
        List<Integer> decreaseIndices = new ArrayList<>();
        // go through the nums array
        for (int i = 0; i < nums.length; i++) {
            // if currNum < top of stack, add this num
            int currSize = decreaseIndices.size();
            if (currSize == 0 || nums[decreaseIndices.get(currSize - 1)] > nums[i]) {
                decreaseIndices.add(i);
            } else {
                // else find largestRamp for this currNum (binary search)
                int currRamp = findLargestRamp(i, decreaseIndices, nums);
                maxRamp = Math.max(currRamp, maxRamp);
            }
        }

        // return maxRamp
        return maxRamp;
    }
    public int maxWidthRampWithDecreasingStackTwoPasses(int[] nums) {
        Stack<Integer> decreasingStack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (decreasingStack.isEmpty() || nums[decreasingStack.peek()] > nums[i]) {
                decreasingStack.push(i);
            }
        }

        int maxRamp = 0;
        for (int right = nums.length - 1; right >= 0; right--) {
            while (!decreasingStack.isEmpty() && nums[decreasingStack.peek()] <= nums[right]) {
                int index = decreasingStack.pop();
                maxRamp = Math.max(maxRamp, right - index);
            }
        }

        return maxRamp;
    }
    private int findLargestRamp(int index, List<Integer> decreaseIndices, int[] nums) {
        int left = 0;
        int right = decreaseIndices.size() - 1;

        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[decreaseIndices.get(mid)] > nums[index]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return index - decreaseIndices.get(left);
    }
    public int maxWidthRampWithSort(int[] nums) {
        Integer[] sortedIndices = new Integer[nums.length];
        for (int i = 0; i < sortedIndices.length; i++) {
            sortedIndices[i] = i;
        }
        // Sort indices based on the input nums
        Arrays.sort(sortedIndices, (a, b) -> (nums[a] - nums[b]));

        int maxRamp = 0;
        int minPoint = Integer.MAX_VALUE;

        for (int i = 0; i < sortedIndices.length; i++) {
            minPoint = Math.min(minPoint, sortedIndices[i]);
            maxRamp = Math.max(maxRamp, sortedIndices[i] - minPoint);
        }

        return maxRamp;
    }
    public int maxWidthRampWithExtraMemory(int[] nums) {
        int maxRamp = 0;
        // built rightMax where rightMax[i] indicates largest value from end to ith position (inclusive)
        int[] rightMax = new int[nums.length];
        int currMax = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightMax[i] = currMax;
            currMax = Math.max(currMax, nums[i]);
        }
        // left, right pointer
        int left = 0;
        int right = 0;
        // go through nums
        while (right < nums.length) {
            // increase right pointer while rightMax[right] >= nums[left]
            while (rightMax[right] >= nums[left]) {
                right++;
            }
            maxRamp = Math.max(maxRamp, right - left);
            right++;
            // increase left pointer until rightMax[right] >= nums[left]
            while (left < right && right < nums.length && nums[left] > rightMax[right]) {
                left++;
            }
        }

        return maxRamp;
    }

    public static void main(String[] args) {
        int[] test1 = {9,3,1,4,0}; // 2
        int[] test2 = {1,2,3,4,5}; // 4
        int[] test3 = {4,3,2,1,0}; // 0;
        int[] test4 = {10,10,10,7,1,6,2,1,7}; // 2

        MaximumWidthRamp maximumWidthRamp = new MaximumWidthRamp();
        System.out.print(maximumWidthRamp.maxWidthRampWithDecreasingStackTwoPasses(test4));
    }

}
