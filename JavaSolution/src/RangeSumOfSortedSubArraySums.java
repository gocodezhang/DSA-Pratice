import java.util.ArrayList;
import java.util.List;

public class RangeSumOfSortedSubArraySums {
    public int rangeSum(int[] nums, int n, int left, int right) {
        // generate all possible subArray sum
        List<Integer> subSums = new ArrayList<>();

        int maxSubSum = 0;
        int minSubSum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSubSum = Math.max(maxSubSum, sum);
                minSubSum = Math.min(minSubSum, sum);
                subSums.add(sum);
            }
        }
        // sort them using bucket sort
        int[] bucket = new int[maxSubSum - minSubSum + 1];

        for (int i = 0; i < subSums.size(); i++) {
            int subSum = subSums.get(i);
            bucket[subSum - minSubSum] = bucket[subSum - minSubSum] + 1;
        }

        // find out the sum from left to right
        long targetSum = 0;
        int counter = 0;
        int index = 0;
        while (index < bucket.length && counter < right) {
            int newCount = counter + bucket[index];
            if (newCount >= left) {
                int sumCount = newCount - counter;
                if (counter < left) {
                    sumCount = sumCount - (left - counter) + 1;
                }
                if (newCount > right) {
                    sumCount = sumCount - (newCount - right);
                }
                targetSum += (sumCount) * (index + minSubSum);
            }
            counter += bucket[index];
            index++;
        }

        return (int) (targetSum % (Math.pow(10, 9) + 7));
    }
    public static void main(String[] args) {
        int[] nums = {65,49,68,65,5,74,12,87,67,98,77,10,96,55,97,27,38,69,77,54,62,50,78,76,30,3,85,1,95,24,39,65,73,33,43,9,64,34,39,99,53,50,50,8,21,83,17,31,37,94,43,8,5,62,54,19,63};
        RangeSumOfSortedSubArraySums rangeSumOfSortedSubArraySums = new RangeSumOfSortedSubArraySums();
        System.out.println(rangeSumOfSortedSubArraySums.rangeSum(nums, 8, 57,57));
    }
}
