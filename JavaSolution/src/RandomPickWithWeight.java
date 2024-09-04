import java.util.HashMap;

public class RandomPickWithWeight {
    int[] prefixSums;
    int total;
    public RandomPickWithWeight(int[] w) {
        prefixSums = new int[w.length];
        int cumulativeSum = 0;
        for (int i = 0; i < w.length; i++) {
            cumulativeSum += w[i];
            prefixSums[i] = cumulativeSum;
        }
        total = cumulativeSum;
    }
    public int pickIndex() {
        double random = Math.random() * total;
        // perform binary search
        int left = 0;
        int right = prefixSums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (prefixSums[mid] >= random) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
