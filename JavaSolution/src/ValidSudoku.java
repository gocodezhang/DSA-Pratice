import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        int width = board[0].length;
        int height = board.length;
        // check all the rows
        for (int i = 0; i < height; i++) {
            Map<Character, Integer> frequencyMap = new HashMap<>();
            for (int j = 0; j < width; j++) {
                char currChar = board[i][j];
                int currFre = frequencyMap.getOrDefault(currChar, 0);
                currFre++;
                if (currChar != '.' && currFre > 1) {
                    return false;
                }
                frequencyMap.put(currChar, currFre);
            }
        }
        // check all columns
        for (int j = 0; j < width; j++) {
            Map<Character, Integer> frequencyMap = new HashMap<>();
            for (int i = 0; i < height; i++) {
                char currChar = board[i][j];
                int currFre = frequencyMap.getOrDefault(currChar, 0);
                currFre++;
                if (currChar != '.' && currFre > 1) {
                    return false;
                }
                frequencyMap.put(currChar, currFre);
            }
        }
        // check subbox
        int[][] startPoints = {
                {0, 0}, {0, 3}, {0, 6},
                {3, 0}, {3, 3}, {3, 6},
                {6, 0}, {6, 3}, {6, 6}
        };
        for (int[] startPoint : startPoints) {
            int row = startPoint[0];
            int col = startPoint[1];
            Map<Character, Integer> frequencyMap = new HashMap<>();
            for (int i = row; i < row + 3; i++) {
                for (int j = col; j < col + 3; j++) {
                    char currChar = board[i][j];
                    int currFre = frequencyMap.getOrDefault(currChar, 0);
                    currFre++;
                    if (currChar != '.' && currFre > 1) {
                        return false;
                    }
                    frequencyMap.put(currChar, currFre);
                }
            }
        }
        return true;
    }
}
