/**
 * Given a mxn matrix, lucy would travel counter-clockwise from cell(0, 0) and the way she travel is hopping (skipping the alternate cell)
 * Write a function that return final position lucy would end in the matrix
 *
 * example
 * 29 8 37
 * 15 41 3
 * 1 10 14
 * output: 41
 * Explanation: Lucy would start from 29. Skip 15 and hop to 1; then skip 10 and hop to 14
 * then skip 3 and hop to 37; finally skip 8 and hop to 41
 */
public class LucyHopGame {
    public static int finalPosition(int[][] matrix) {
        int length = matrix.length;
        int width = matrix[0].length;
        int left = 0;
        int right = matrix[0].length - 1;
        int up =  0;
        int bottom = matrix.length - 1;
        int count = 0;
        int row = -1;
        int col = 0;
        String prevStep = "";
        while (count < length * width) {
            for (int i = up; i <= bottom; i++) {
                prevStep = "down";
                row++;
                count++;
            }
            for (int i = left + 1; i <= right; i++) {
                prevStep = "right";
                col++;
                count++;
            }
            if (up != bottom) {
                for (int i = bottom - 1; i >= up; i--) {
                    prevStep = "up";
                    row--;
                    count++;
                }
            }
            if (left != right) {
                for (int i = right - 1; i >= left + 1; i--) {
                    prevStep = "left";
                    col--;
                    count++;
                }
            }
            left++;
            right--;
            up++;
            bottom--;
        }
        if (length * width % 2 == 0) {
            if (prevStep == "down") {
                row--;
            } else if (prevStep == "right") {
                col--;
            } else if (prevStep == "up") {
                row++;
            } else {
                row++;
            }
        }
        return matrix[row][col];
    }
    public static void main(String[] args) {
        int[][] matrix1 = {
                {29, 8, 37},
                {15, 41, 3},
                {1, 10, 14}
        };
        int[][] matrix2 = {
                {9, 8, 7, 6},
                {5, 4, 3, 2},
                {1, 10, 11, 12}
        };
        int[][] matrix3 = {
                {1, 12, 11, 10},
                {2, 13, 16, 9},
                {3, 14, 15, 8},
                {4, 5, 6, 7}
        };
        System.out.println(finalPosition(matrix1));
        System.out.println(finalPosition(matrix2));
        System.out.println(finalPosition(matrix3));
    }
}
