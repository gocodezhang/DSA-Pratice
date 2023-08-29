import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public static void mutateRooms(int[][] rooms) {
        int length = rooms.length;
        int width = rooms[0].length;
        // create queue
        Queue<int[]> queue = new LinkedList<>();
        // iterate through matrix
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                // check if currPosition == 0
                if (rooms[i][j] == 0) {
                    // push currPosition into queue
                    queue.add(new int[]{i, j});
                }
            }
        }
        int distance = 0;
        // while (queue is not empty)
        while (queue.size() > 0 ) {
            // length = queue.size();
            int currSize = queue.size();
            distance++;
            // for ( i < length)
            for (int index = 0; index < currSize; index++) {
                // startingPoint = queue.pop();
                int[] startingPoint = queue.poll();
                bfs(startingPoint, distance, rooms, queue);
            }
        }

    }
    public static void bfs(int[] position, int distance, int[][] rooms, Queue<int[]> queue) {
        int length = rooms.length;
        int width = rooms[0].length;
        int[][] options = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };
        for (int[] option : options) {
            int[] nextPosition = {position[0] + option[0], position[1] + option[1]};
            if ((nextPosition[0] < 0 || nextPosition[0] >= length) || (nextPosition[1] < 0 || nextPosition[1] >= width)) {
                continue;
            }
            if (rooms[nextPosition[0]][nextPosition[1]] == Integer.MAX_VALUE) {
                rooms[nextPosition[0]][nextPosition[1]] = distance;
                queue.add(nextPosition);
            }
        }
    }
    public static void main(String[] args) {
        int[][] rooms = {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE,}
        };
        mutateRooms(rooms);
        System.out.println(Arrays.deepToString(rooms));
    }
}
