import java.util.*;

public class DivideIntervalsIntoMinimumGroups {
    public int minGroups(int[][] intervals) {
        // sort intervals
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // go through intervals
        List<Integer> group = new ArrayList<>();
        for (int[] interval : intervals) {
            // for each intervals
            boolean merged = false;
            // check max in each group
            for (int i = 0; i < group.size(); i++) {
                int end = group.get(i);
                // if max < start intervals, then update the group
                if (end < interval[0]) {
                    merged = true;
                    group.set(i, interval[1]);
                    break;
                }
            }
            // if cannot fit into any group, then create new group
            if (!merged) {
                group.add(interval[1]);
            }
        }
        // return group size
        return group.size();
    }
    public int minGroupsHeap(int[][] intervals) {
        // sort the intervals
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int maxConcurrent = 0;
        // go through intervals
        for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            // curr interval
            // remove the finished intervals
            while (!minHeap.isEmpty() && currInterval[0] > minHeap.peek()) {
                minHeap.poll();
            }
            // add the curr
            minHeap.add(currInterval[1]);
            // try update maxConcurr (size of heap is concurr intervals)
            maxConcurrent = Math.max(maxConcurrent, minHeap.size());
        }

        // return maxConcurr
        return maxConcurrent;
    }
    public int minGroupsHeapOptimize(int[][] intervals) {
        // sort the intervals
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // go through intervals
        for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            // curr interval
            // check if we can use any existing group
            if (!minHeap.isEmpty() && currInterval[0] > minHeap.peek()) {
                // yes, use existing group by removing the top
                minHeap.poll();
            }
            // add curr interval into group
            minHeap.add(currInterval[1]);
        }

        // return maxConcurr
        return minHeap.size();
    }
    public int minGroupsEvents(int[][] intervals) {
        int n = intervals.length;
        List<int[]> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] interval = intervals[i];
            events.add(new int[]{interval[0], 1});
            events.add(new int[]{interval[1] + 1, -1});
        }

        // sort the events
        Collections.sort(events, (a, b) -> {
            if (a[0] - b[0] != 0) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        // System.out.println(events);

        int currIntervals = 0;
        int maxIntervals = 0;

        for (int i = 0; i < events.size(); i++) {
            int[] event = events.get(i);
            currIntervals += event[1];
            maxIntervals = Math.max(maxIntervals, currIntervals);
        }

        return maxIntervals;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,4}};
        DivideIntervalsIntoMinimumGroups dm = new DivideIntervalsIntoMinimumGroups();
        System.out.println(dm.minGroupsEvents(intervals));
    }
}
