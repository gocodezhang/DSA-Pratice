import java.util.Arrays;
import java.util.PriorityQueue;

public class NumOfSmallestAvailableChair {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        Integer[] friends = new Integer[n];

        for (int i = 0; i < n; i++) {
            friends[i] = i;
        }
        Arrays.sort(friends, (a, b) -> times[a][0] - times[b][0]);

        int[] chairs = new int[n];

        for (int i = 0; i < n; i++) {
            int friend = friends[i];

            int[] time = times[friend];

            int chairIndex = 0;
            while (chairs[chairIndex] > time[0]) {
                chairIndex++;
            }
            chairs[chairIndex] = time[1];

            if (friend == targetFriend) {
                return chairIndex;
            }
        }

        return -1;
    }
    public int smallestChairPQ(int[][] times, int targetFriend) {
        // this event queue can be optimized using a sorted array
        PriorityQueue<int[]> eventQueue = new PriorityQueue<>((a, b) -> (a[2] - b[2]));

        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];
            int[] arrEvent = {i, 1, time[0]};
            int[] leaveEvent = {i, 0, time[1]};
            eventQueue.add(arrEvent);
            eventQueue.add(leaveEvent);
        }

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            availableChairs.add(i);
        }
        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>((a, b) -> (a[1] - b[1]));

        while (!eventQueue.isEmpty()) {
            int[] event = eventQueue.poll();
            int friend = event[0];

            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[1] <= event[2]) {
                int[] freeChair = occupiedChairs.poll();
                availableChairs.add(freeChair[0]);
            }
            if (event[1] == 1) {
                int chair = availableChairs.poll();
                occupiedChairs.add(new int[]{chair, times[friend][1]});
                if (friend == targetFriend) {
                    return chair;
                }
            }
        }

        return -1;
    }
    public int smallestChairPQOptimal(int[][] times, int targetFriend) {

    }
    public static void main(String[] args) {
        int[][] times = {
                {3,10},
                {1,5},
                {2,6}
        };
        NumOfSmallestAvailableChair numofSmallestAvailableChair = new NumOfSmallestAvailableChair();
        System.out.println(numofSmallestAvailableChair.smallestChairPQ(times, 0));
    }

}
