import java.util.*;

public class SurroundedRegions {
    public static void solve(char[][] board) {
        int length = board.length;
        int width = board[0].length;
        // iterate through matrix
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                // if (curr position == 'O')
                if (board[i][j] == 'O') {
                    // create visited
                    Set<String> visited = new HashSet<>();
                    int[] currPosition = {i, j};
                    // dfs
                    if (dfs(currPosition, visited, board)) {
                        // iterate through visited
                        Iterator<String> visitedIterator = visited.iterator();
                        while (visitedIterator.hasNext()) {
                            // turn the positoin = 'X'
                            String visitedPoint = visitedIterator.next();
                            int cuttingPoint = visitedPoint.indexOf('-');
                            int visitedRow = Integer.parseInt(visitedPoint.substring(0, cuttingPoint));
                            int visitedCol = Integer.parseInt(visitedPoint.substring(cuttingPoint + 1));
                            board[visitedRow][visitedCol] = 'X';
                        }
                    }

                }
            }
        }
    }
    public static boolean dfs(int[] position, Set<String> visited, char[][] board) {
        int length = board.length;
        int width = board[0].length;
        // base case
        // if (currPosition is at vertical or honriontal boundary)
        if ((position[0] == 0 || position[0] == length - 1) || (position[1] == 0 || position[1] == width - 1)) {
            // return false
            return false;
        }
        // options
        int[][] options = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };
        // add currPosition into visited
        visited.add(position[0] + "-" + position[1]);
        // recursive case
        // iterate through options
        for (int[] option : options) {
            // compute the next position
            int[] nextPosition = {position[0] + option[0], position[1] + option[1]};
            // if (next position == 'O')
            if (board[nextPosition[0]][nextPosition[1]] == 'O' && !visited.contains(nextPosition[0] + "-" + nextPosition[1])) {
                if (!dfs(nextPosition, visited, board)) {
                    return false;
                }
            }
        }
        // return true
        return true;
    }
    public static void main(String[] args){
        char[][] board = {
                {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'X', 'O', 'O', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'X'},
                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X'},
                {'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'X', 'O', 'X', 'X', 'O', 'X', 'X', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X'},
                {'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'X', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'O', 'O'},
                {'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'X', 'X', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O'}
        };
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
