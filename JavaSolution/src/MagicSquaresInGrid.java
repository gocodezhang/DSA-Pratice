public class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= columns - 3; j++) {
                if (validate(i, j, grid)) {
                    count++;
                }
            }
        }

        return count;
    }
    public boolean validate(int i, int j, int[][] grid) {
        int[] visited = new int[10];
        int[] columns = new int[3];
        int forwardDiagonal = 0;
        int backwardDiagonal = 0;
        int distinctSum = -1;

        for (int row = i; row < i + 3; row++) {
            int currRowSum = 0;
            for (int column = j; column < j + 3; column++) {
                int num = grid[row][column];
                if (num > 9 || num < 1 || visited[num] == 1) {
                    return false;
                }
                visited[num] = 1;
                currRowSum += num;
                columns[column - j] = columns[column - j] + num;
                if (row - i == column - j) {
                    backwardDiagonal += num;
                }
                if (row - i + column - j == 2) {
                    forwardDiagonal += num;
                }
            }
            if (distinctSum == -1) {
                distinctSum = currRowSum;
            }
            if (distinctSum != currRowSum) {
                return false;
            }
        }
        for (int columnSum : columns) {
            if (columnSum != distinctSum) {
                return false;
            }
        }
        if (forwardDiagonal != distinctSum || backwardDiagonal != distinctSum) {
            return false;
        }

        return true;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {4,3,8,4},{9,5,1,9},{2,7,6,2}
        };
        MagicSquaresInGrid magicSquaresInGrid = new MagicSquaresInGrid();
        System.out.println(magicSquaresInGrid.numMagicSquaresInside(grid));
    }

}
