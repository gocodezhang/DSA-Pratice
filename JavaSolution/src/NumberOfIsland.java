import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        // islandCount = 0
        int islandCount = 0;
        // visited set
        HashSet<String> visited = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        // for 0 <= i < m
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited.contains(i + ":" + j)) {
                    dfs(i, j, visited, grid);
                    islandCount += 1;
                }
            }
        }

        // return islandCount
        return islandCount;
    }
    public void dfs(int i, int j, HashSet<String> visited, char[][] grid) {
        // base case
        // if (currPosition == 0 || visited.has(currPosition))
        int m = grid.length;
        int n = grid[0].length;
        boolean outBound = i < 0 || i >= m || j < 0 || j >= n;
        if (outBound || grid[i][j] == '0' || visited.contains(i + ":" + j)) {
            return;
        }
        // add currPostion into visited
        int[][] directions = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };
        visited.add(i + ":" + j);
        // recursive case
        // for direction in Directions
        for (int[] direction: directions) {
            // dfs(currPosition + direction, gird, visited)
            dfs(i + direction[0], j + direction[1], visited, grid);
        }
    }
    public int numIslandsBFS(char[][] grid) {
        // islandCount = 0
        int islandCount = 0;
        // visited set
        HashSet<String> visited = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        // for 0 <= i < m
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited.contains(i + ":" + j)) {
                    bfs(i, j, visited, grid);
                    islandCount += 1;
                }
            }
        }

        // return islandCount
        return islandCount;
    }
    public void bfs(int i, int j, HashSet<String> visited, char[][] grid) {
        int[][] directions = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (queue.size() > 0) {
            int[] currPos = queue.poll();
            visited.add(currPos[0] + ":" + currPos[1]);
            for (int[] direction: directions) {
                int pi = currPos[0] + direction[0];
                int pj = currPos[1] + direction[1];
                boolean bound = pi >= 0 && pi < m && pj >= 0 && pj < n;
                if (bound && !visited.contains(pi + ":" + pj) && grid[pi][pj] == '1') {
                    queue.add(new int[]{pi, pj});
                }
            }
        }
    }
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        NumberOfIsland numberOfIsland = new NumberOfIsland();
        System.out.println(numberOfIsland.numIslandsBFS(grid));
    }
}
