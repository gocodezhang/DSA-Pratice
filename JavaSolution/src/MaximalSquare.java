import java.util.Arrays;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];

        boolean isAllZeros = true;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][columns - 1] == '1') {
                isAllZeros = false;
                dp[i][columns - 1] = matrix[i][columns - 1] - '0';
            }
        }
        for (int i = 0; i < columns; i++) {
            if (matrix[rows - 1][i] == '1') {
                isAllZeros = false;
                dp[rows - 1][i] = matrix[rows - 1][i] - '0';
            }
        }

        int maxDimension = 0;
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = columns - 2; j >= 0; j--) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                isAllZeros = false;
                int min = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1]));


                dp[i][j] = min + 1;
                maxDimension = Math.max(maxDimension, min + 1);

            }
        }

        if (isAllZeros) {
            return 0;
        }
        return Math.max(1, maxDimension * maxDimension);
    }
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','1','1','1','0'},
                {'1','1','1','1','0'},
                {'1','1','1','1','1'},
                {'1','1','1','1','1'},
                {'0','0','1','1','1'}
        };
        MaximalSquare maximalSquare = new MaximalSquare();
        System.out.println(maximalSquare.maximalSquare(matrix));
    }
}
