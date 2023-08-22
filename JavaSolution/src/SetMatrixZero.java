import java.util.HashSet;
import java.util.Set;

public class SetMatrixZero {
    public static void setZeros(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<String> visited = new HashSet<>();
        // for (int i = 0; i < m; i++)
        for (int i = 0; i < m; i++) {
            // for (int j = 0; j < n; j++)
            for (int j = 0; j < n; j++) {
                // check if matrix[i][j] == 0
                if (matrix[i][j] == 0 && !visited.contains(i + "-" + j)) {
                    // turn ith row to 0
                    turnRow(i, matrix, visited);
                    // turn jth column to 0
                    turnColumn(j, matrix, visited);
                }
            }
        }

    }
    public static void turnRow(int i, int[][] matrix, Set<String> visited) {
        int m = matrix.length;
        int n = matrix[0].length;
        // turnRow(i, matrix)
        // for (int j = 0; j < n; j++)
        for (int j = 0; j < n; j++) {
            // matrix[i][j] = 0
            if (matrix[i][j] != 0) {
                matrix[i][j] = 0;
                visited.add(i + "-" + j);
            }
        }
    }
    public static void turnColumn(int j, int[][] matrix, Set<String> visited) {
        int m = matrix.length;
        int n = matrix[0].length;
        // turnColumn(j, matrix)
        // for (int i = 0; i < m; i++)
        for (int i = 0; i < m; i++) {
            // matrix[i][j] = 0;
            if (matrix[i][j] != 0) {
                matrix[i][j] = 0;
                visited.add(i + "-" + j);
            }
        }
    }
    public static void setZeros2(int[][] matrix) {
        boolean setFirstRow = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (i > 0) {
                        matrix[i][0] = 0;
                    } else {
                        setFirstRow = true;
                    }
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (setFirstRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        setZeros2(matrix);
    }
}
