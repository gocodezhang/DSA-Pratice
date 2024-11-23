public class FindValidMatrixGivenRCSum {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] matrix = new int[rowSum.length][colSum.length];
        int row = matrix.length;
        int col = matrix[0].length;
        // fill the largest possible value based on constraint
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int largest = Math.min(rowSum[i], colSum[j]);
                matrix[i][j] = largest;
                rowSum[i] = rowSum[i] - largest;
                colSum[j] = colSum[j] - largest;
            }
        }

        return matrix;
    }
    public static void main(String[] args) {
        FindValidMatrixGivenRCSum findValidMatrixGivenRCSum = new FindValidMatrixGivenRCSum();
        int[] rowSum = {5, 10};
        int[] colSum = {3,7,5};
        int[][] result = findValidMatrixGivenRCSum.restoreMatrix(rowSum, colSum);

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                builder.append(result[i][j]);
            }
            builder.append('\n');
        }
        System.out.println(builder.toString());
    }

}
