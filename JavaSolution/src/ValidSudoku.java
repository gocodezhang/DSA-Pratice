import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
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
    public boolean isValidSudokuOnePass(char[][] board) {
        int n = board.length;
        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] columns = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char currChar = board[i][j];
                if (currChar == '.') {
                    continue;
                }
                if (rows[i].contains(currChar)) {
                    return false;
                }
                rows[i].add(currChar);
                if (columns[j].contains(currChar)) {
                    return false;
                }
                columns[j].add(currChar);

                int box = 3 * (i / 3) + j / 3;
                if (boxes[box].contains(currChar)) {
                    return false;
                }
                boxes[box].add(currChar);
            }
        }
        return true;
    }
}
