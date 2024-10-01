import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        timePoints.sort((a, b) -> calculateTimeDiff(a, b));

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); i++) {
            int diff;
            if (i == timePoints.size() - 1) {
                diff = calculateTimeDiff(timePoints.get(i), timePoints.get(0));
            } else {
                diff = calculateTimeDiff(timePoints.get(i), timePoints.get(i + 1));
            }
            int minDiff = Math.min(Math.abs(diff), Math.abs(24 * 60 - diff));
            min = Math.min(min, minDiff);
        }
        return min;
    }
    private int calculateTimeDiff(String a, String b) {
        String[] timeA = a.split(":");
        String[] timeB = b.split(":");
        int hourDiff = Integer.parseInt(timeA[0]) - Integer.parseInt(timeB[0]);
        int minuteDiff = Integer.parseInt(timeA[1]) - Integer.parseInt(timeB[1]);

        return hourDiff * 60 + minuteDiff;
    }
    public int findMinDifferenceCountingSort(List<String> timePoints) {
        boolean[] timeSlots = new boolean[24 * 60];
        for (int i = 0; i < timePoints.size(); i++) {
            String timePoint = timePoints.get(i);
            String[] timeParsed = timePoint.split(":");
            int timeInMinute = Integer.parseInt(timeParsed[0]) * 60 + Integer.parseInt(timeParsed[1]);
            if (timeSlots[timeInMinute]) {
                return 0;
            }
            timeSlots[timeInMinute] = true;
        }

        int prevIndex = -1;
        int min = Integer.MAX_VALUE;
        int first = -1;
        int last = -1;

        for (int i = 0; i < timeSlots.length; i++) {
            if (timeSlots[i]) {
                if (prevIndex != -1) {
                    min = Math.min(i - prevIndex, min);
                } else {
                    first = i;
                }
                prevIndex = i;
                last = i;
            }
        }

        return Math.min(min, 24 * 60 - (last - first));
    }
    public static void main(String[] args) {
        List<String> times = Arrays.asList("00:00","23:59");
        MinimumTimeDifference minimumTimeDifference = new MinimumTimeDifference();
        System.out.println(minimumTimeDifference.findMinDifference(times));
    }
}
