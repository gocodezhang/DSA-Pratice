import java.util.*;

public class GameOfLife {
    public static void updateToNextGen(int[][] board) {
        int height = board.length;
        int width = board[0].length;
        //Create updates
        List<int[]> updates = new ArrayList<>();
        //Iterate through the board
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // currPosition
                int[] currPosition = new int[]{i, j};
                // checkUpdate(currPosition, board)
                if (checkUpdate(currPosition, board)) {
                    updates.add(currPosition);
                }
            }
        }
        // Iterate updates
        for (int i = 0; i < updates.size(); i++) {
            // update the curr position
            int[] updatePos = updates.get(i);
            board[updatePos[0]][updatePos[1]] = board[updatePos[0]][updatePos[1]] == 0 ? 1 : 0;
        }
    }
    public static boolean checkUpdate(int[] currPosition, int[][] board) {
        int height = board.length;
        int width = board[0].length;
        // create map contained all possible directions
        Map<String, int[]> directions = new HashMap<>();
        directions.put("up", new int[]{0, -1});
        directions.put("down", new int[]{0, 1});
        directions.put("left", new int[]{-1, 0});
        directions.put("right", new int[]{1, 0});
        directions.put("upperLeft", new int[]{-1, -1});
        directions.put("upperRight", new int[]{1, -1});
        directions.put("bottomLeft", new int[]{-1, 1});
        directions.put("bottomRight", new int[]{1, 1});

        int liveCount = 0;
        // iterate through map
        for (String key : directions.keySet()) {
            int[] currDirection = directions.get(key);
            // updatedPosition
            int[] updatedPosition = new int[]{currPosition[0] + currDirection[0], currPosition[1] + currDirection[1]};
            // check if the updatedPosition is within range
            if ((updatedPosition[0] >= 0 && updatedPosition[0] < height) && (updatedPosition[1] >= 0 && updatedPosition[1] < width)) {
                //increase liveCount if the updatesPosition = 1
                if (board[updatedPosition[0]][updatedPosition[1]] == 1) {
                    liveCount++;
                }
            }
        }
        // currPostion is live and liveCount are not 2 or 3
        if (board[currPosition[0]][currPosition[1]] == 1 && liveCount != 2 && liveCount != 3) {
            return true;
        }
        // currPostion is dead and liveCount == 3
        if (board[currPosition[0]][currPosition[1]] == 0 && liveCount == 3) {
            return true;
        }
        // return false
        return false;
    }
    public static void main(String[] args) {
        int[][] board = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        updateToNextGen(board);
        System.out.println(Arrays.deepToString(board));
    }
}
