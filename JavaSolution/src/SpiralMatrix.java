import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int up = 0;
        int left = 0;
        int down = matrix.length;
        int right = matrix[0].length;
        List<Integer> resultList = new ArrayList<>();

        while (resultList.size() < matrix.length * matrix[0].length) {
            for (int i = left; i < right; i++) {
                resultList.add(matrix[up][i]);
            }
            for (int i = up + 1; i < down; i++) {
                resultList.add(matrix[i][right - 1]);
            }
            if (up != down) {
                for (int i = right - 2; i >= left; i--) {
                    resultList.add(matrix[down - 1][i]);
                }
            }
            if (left != right) {
                for (int i = down - 2; i > up; i--) {
                    resultList.add(matrix[i][left]);
                }
            }
            up++;
            down--;
            left++;
            right--;
        }
        return resultList;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {8, 9, 4},
                {7, 6, 5},
        };
        System.out.println(spiralOrder(matrix).toString());
    }
}
