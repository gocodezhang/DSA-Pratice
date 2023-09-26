import java.util.HashMap;
import java.util.Map;

public class TicTacToe {
    int size;
    Map<Integer, int[]> memoObj;
    public TicTacToe(int n) {
        size = n;
        // build memoObj
        memoObj = new HashMap<>();
        memoObj.put(1, new int[2*size + 2]);
        memoObj.put(2, new int[2*size + 2]);
    }
    /**
     * Further optimization can be achieved
     * currently, we are tracking every row and col for both players;
     * but given every move will be validated, we can track every row and col for the board
     */
    public int move(int row, int col, int player) {
        int[] memoArr = memoObj.get(player);
        memoArr[row] = memoArr[row] + 1;
        if (memoArr[row] == size) {
            return player;
        }
        memoArr[col + size] = memoArr[col + size] + 1;
        if (memoArr[col + size] == size) {
            return player;
        }
        if (row == col) {
            memoArr[2*size] = memoArr[2*size] + 1;
            if (memoArr[2*size] == size) {
                return player;
            }
        }
        if (row + col + 1 == size) {
            memoArr[2*size + 1] = memoArr[2*size + 1] + 1;
            if (memoArr[2*size + 1] == size) {
                return player;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        TicTacToe test = new TicTacToe(2);
        int[][] moves = {{0, 0, 2}, {0, 1, 1}, {1, 1, 2}};
        for (int i = 0; i < moves.length; i++) {
            int[] move = moves[i];
            System.out.println(test.move(move[0], move[1], move[2]));
        }
    }
}
