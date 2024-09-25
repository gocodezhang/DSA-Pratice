import java.util.HashSet;

public class RegionsCutBySlashes {
    int[][] directions = new int[][]{{1, 0},{-1, 0},{0, 1}, {0, -1}};
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;

        // create an expanded grid 3x3
        int[][] intGrid = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            String currRow = grid[i];
            for (int j = 0; j < currRow.length(); j++) {
                int gridRow = i * 3;
                int gridColumn = j * 3;
                if (currRow.charAt(j) == '/') {
                    intGrid[gridRow][gridColumn + 2] = 1;
                    intGrid[gridRow + 1][gridColumn + 1] = 1;
                    intGrid[gridRow + 2][gridColumn] = 1;
                } else if (currRow.charAt(j) == '\\') {
                    intGrid[gridRow + 2][gridColumn + 2] = 1;
                    intGrid[gridRow + 1][gridColumn + 1] = 1;
                    intGrid[gridRow][gridColumn] = 1;
                }
            }
        }
        HashSet<String> visited = new HashSet<>();
        int counter = 0;

        for (int i = 0; i < 3 * n; i++) {
            for (int j = 0; j < 3 * n; j++) {
                if (intGrid[i][j] == 0 && !visited.contains(i + "-" + j)) {
                    counter++;
                    dfs(i, j, intGrid, visited);
                }
            }
        }

        return counter;
    }

    public void dfs(int i , int j, int[][] intGrid, HashSet<String> visited) {
        int size = intGrid.length;
        // base case
        if (i < 0 || i >= size || j < 0 || j >= size) {
            return;
        }
        if (visited.contains(i + "-" + j) || intGrid[i][j] != 0) {
            return;
        }

        visited.add(i + "-" + j);

        for (int[] direction : directions) {
            dfs(i + direction[0], j + direction[1], intGrid, visited);
        }
    }

    public static void main(String[] args) {
        String[] grid = new String[]{"/\\","\\/"};
        RegionsCutBySlashes regionsCutBySlashes = new RegionsCutBySlashes();
        System.out.println(regionsCutBySlashes.regionsBySlashes(grid));
    }



}
