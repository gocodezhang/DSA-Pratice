import java.util.HashSet;

public class BattleshipsInBoard {
    public int countBattleships(char[][] board) {
        HashSet<String> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X' && !visited.contains(i + "-" + j)) {
                    count++;
                    dfs(-1, i, j, board, visited);
                }
            }
        }
        return count;
    }
    public void dfs(int direction, int i, int j, char[][] board, HashSet<String> visited) {
        // direction = -1: down and right
        // direction = 0: down
        // direction = 1: right
        int rows = board.length;
        int columns = board[0].length;
        // base case
        if ((i < 0 || i >= rows) || (j < 0 || j >= columns)) {
            return;
        }
        if (visited.contains(i + "-" + j) || board[i][j] != 'X') {
            return;
        }

        visited.add(i +  "-" + j);
        // recursive case
        if (direction == -1) {
            dfs(0, i + 1, j, board, visited);
            dfs(1, i, j + 1, board, visited);
        } else if (direction == 0) {
            dfs(0, i + 1, j, board, visited);
        } else {
            dfs(1, i, j + 1, board, visited);
        }


    }
}
