public class RotateImage {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int top = left;
            int bottom = right;
            for (int i = 0; i < right - left; i++) {
                int tmp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = tmp;
            }
            left++;
            right--;
        }
    }
    public static void rotate2(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }
    public static void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    public static void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int rp = n - j - 1;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][rp];
                matrix[i][rp] = tmp;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        rotate2(matrix);
    }
}
