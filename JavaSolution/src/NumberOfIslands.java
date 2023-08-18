import java.util.HashMap;
import java.util.Map;

public class NumberOfIslands {
    public static int numsIslands(char[][] grid) {
        int height = grid.length;
        int length = grid[0].length;
        int counter = 0;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < length; col++) {
                if (grid[row][col] == '1') {
                    counter += 1;
                    adjacentSearch(row, col, grid);
                }
            }
        }
        return counter;
    }
    public static void adjacentSearch(int row, int col, char[][] matrix) {
        int height = matrix.length;
        int length = matrix[0].length;
        if (row < 0 || row >= height || col < 0 || col >= length || matrix[row][col] == '0') {
            return;
        }
        matrix[row][col] = '0';
        adjacentSearch(row - 1, col, matrix);
        adjacentSearch(row + 1, col, matrix);
        adjacentSearch(row, col - 1, matrix);
        adjacentSearch(row, col + 1, matrix);
    }
    public static void main(String[] args) {
        char[][] grid =new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numsIslands(grid));
    }
}
