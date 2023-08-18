import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        intervals = insertNewInterval(intervals, newInterval);

        for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            while (i + 1 < intervals.length && overlap(currInterval, intervals[i + 1])) {
                currInterval = merge(currInterval, intervals[i + 1]);
                i += 1;
            }
            result.add(currInterval);
        }


        return result.toArray(new int[result.size()][2]);
    }

    public static int[][] insertNewInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> intervalsList = new ArrayList<>(Arrays.asList(intervals));
        Boolean insert = false;
        for (int i = 0; i < intervalsList.size(); i++) {
            if (intervalsList.get(i)[0] > newInterval[0]) {
                insert = true;
                intervalsList.add(i, newInterval);
                break;
            }
        }
        if (!insert) {
            intervalsList.add(newInterval);
        }
        return intervalsList.toArray(new int[intervalsList.size()][2]);
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
                {6, 9}
        };
        int[] newInterval = {2, 5};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }
}
