import java.util.Stack;

public class SumOfSubArrRanges {
    public static long subArrayRanges(int[] nums) {
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            Long[] currSubArr = new Long[2];
            result += dfs(i, currSubArr, nums);
        }
        return result;
    }
    public static long dfs(int currIndex, Long[] currSubArr, int[] nums) {
        // base case
        if (currIndex >= nums.length) {
            return 0;
        }
        // currElement = nums[i]
        long currElement = nums[currIndex];

        // recursive case
        // if (min == null || min - 1 == currElement)
        if (currSubArr[0] == null || currSubArr[0] > currElement) {
            currSubArr[0] = currElement;
        }
        // if (min == null || max + 1 == currElement)
        if (currSubArr[1] == null || currSubArr[1] < currElement) {
            currSubArr[1] = currElement;
        }
        // currRange = integer[1] - integer[0];
        long currRange = currSubArr[1] - currSubArr[0];
        // return currRange
        return currRange + dfs(currIndex + 1, currSubArr, nums);
    }
    public static long subArrayRangesOptimal(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        long sumOfMin = 0;
        for (int right = 0; right <= nums.length; right++) {
            while (!stack.empty() && (right == nums.length || nums[stack.peek()] >= nums[right])) {
                int minIndex = stack.pop();
                int left = stack.empty() ? -1 : stack.peek();
                long sumOfCurrMin = (long) (right - minIndex) * (minIndex - left) * nums[minIndex];
                sumOfMin += sumOfCurrMin;
            }
            stack.add(right);
        }
        stack = new Stack<>();
        long sumOfMax = 0;
        for (int right = 0; right <= nums.length; right++) {
            while (!stack.empty() && (right == nums.length || nums[stack.peek()] <= nums[right])) {
                int maxIndex = stack.pop();
                int left = stack.empty() ? -1 : stack.peek();
                long sumOfCurrMax = (long) (right - maxIndex) * (maxIndex - left) * nums[maxIndex];
                sumOfMax += sumOfCurrMax;
            }
            stack.add(right);
        }
        return sumOfMax - sumOfMin;
    }
    public static void main(String[] main) {
        int[] nums = {4,-2,-3,4,1};
        System.out.println(subArrayRangesOptimal(nums));
    }
}
