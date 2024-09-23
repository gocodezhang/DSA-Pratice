public class MinimumSwapsGroupAll1s {
    public int minSwaps(int[] data) {
        // find out how many ones
        // preFixSum
        int[] prefixSums = new int[data.length + 1];
        prefixSums[0] = 0;
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
            prefixSums[i + 1] = sum;
        }
        int max = 0;
        for (int i = sum; i <= data.length; i++) {
            max = Math.max(max, prefixSums[i] - prefixSums[i - sum]);
        }

        return sum - max;
    }
}
