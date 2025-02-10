import java.util.Arrays;

public class FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        // sum of m and sum (m + n)
        int sumMN = mean * (rolls.length + n);
        int sumM = 0;
        for (int i = 0; i < m; i++) {
            sumM += rolls[i];
        }
        // check diff is in range
        int diff = sumMN - sumM;
        if (diff < n || diff > 6 * n) {
            // if not in range, return empty array
            return new int[]{};
        }
        // else build the array
        int[] result = new int[n];
        int avg = diff / n;
        int remaining = diff - avg * n;

        for (int i = 0; i < n; i++) {
            result[i] = avg;
            if (remaining > 0) {
                result[i] = result[i] + 1;
                remaining--;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        FindMissingObservations fo = new FindMissingObservations();
        int[] nums = {1,5,6};
        System.out.println(Arrays.toString(fo.missingRolls(nums, 3, 4)));
    }
}
