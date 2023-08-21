import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public static int[][] merge(int[][] intervals) {
        // Sort the intervals based on start time
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
        // Create an empty list (resultList)
        List<int[]> resultList = new ArrayList<>();
        // for (int i = 0; i < intervals.length; i++)
        for (int i = 0; i < intervals.length; i++) {
            // currInterval = intervals[i];
            int[] currInterval = intervals[i];
            // while (currInterval is overlapped with next Interval)
            while (i != intervals.length - 1 && overlap(currInterval, intervals[i + 1])) {
                // currInterval = merge(currInterval, nextInterval)
                currInterval = merge(currInterval, intervals[i + 1]);
                // i++
                i++;
            }
            // add currInterval into resultList
            resultList.add(currInterval);
        }

        // return resultList
        return resultList.toArray(new int[resultList.size()][2]);

    }
    public static boolean overlap(int[] interval1, int[] interval2) {
        return Math.min(interval1[1], interval2[1]) - Math.max(interval1[0], interval2[0]) >= 0;
    }
    public static int[] merge(int[] interval1, int[] interval2) {
        return new int[]{Math.min(interval1[0], interval2[0]), Math.max(interval1[1], interval2[1])};
    }
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

}
