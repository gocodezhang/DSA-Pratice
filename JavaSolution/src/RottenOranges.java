import java.util.*;

public class RottenOranges {
    static int freshOranges = 0;
    static int time = -1;
    static int length;
    static int width;
    static int[][] matrix;
    public static int orangesRotting(int[][] grid) {
        matrix = grid;
        length = grid.length;
        width = grid[0].length;
        // Create queue (storing the rotten position)
        Queue<int[]> queue = new LinkedList<>();
        // create visited (storing visited position)
        Set<String> visited = new HashSet<>();

        // iterate through the matrix
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                // check if curr position == 2
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    // check if curr position == 1
                    // increase freshOranges
                    freshOranges++;
                }
            }
        }
        if (freshOranges == 0) {
            return 0;
        }
        // while (queue is not empty)
        while (queue.size() != 0) {
            // curr length of queue
            int currLength = queue.size();
            // time++
            time++;
            // for ( i < curr length)
            for (int i = 0; i < currLength; i++) {
                // position = queue.pop()
                int[] position = queue.poll();
                // not needed: visited.add(position[0] + "-" + position[1]);
                // bfs(position)
                bfs(position, visited, queue);
            }

        }
        // check if oranges == 0
        if (freshOranges == 0) {
            return time;
        } else {
            return - 1;
        }

    }
    public static void bfs(int[] position, Set<String> visited, Queue<int[]> queue) {
        int[][] options = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1},
        };
        for (int i = 0; i < options.length; i++) {
            int[] nextPosition = {position[0] + options[i][0], position[1] + options[i][1]};
            if (!visited.contains(nextPosition[0] + "-" + nextPosition[1]) && (nextPosition[0] >= 0 && nextPosition[0] < length)
            && (nextPosition[1] >= 0 && nextPosition[1] < width)) {
                if (matrix[nextPosition[0]][nextPosition[1]] == 1) {
                    freshOranges--;
                    queue.add(nextPosition);
                }
                visited.add(nextPosition[0] + "-" + nextPosition[1]);
            }
        }

    }
    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(orangesRotting(grid));
    }
}
