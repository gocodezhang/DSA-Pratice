import java.util.Arrays;
import java.util.Comparator;

public class NonoverlapInterval {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (end > intervals[i][0]) {
                ans++;
                end = Math.min(end, intervals[i][1]);
            } else {
                end = intervals[i][1];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
