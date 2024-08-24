import java.util.*;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        // create a distance array
        int[] distance = new int[n*n + 1];
        Arrays.fill(distance, -1);
        // perform bfs starting from 1
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        distance[1] = 0;
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            for (int nextNode = currNode + 1; nextNode <= Math.min(currNode + 6, n * n); nextNode++) {
                int[] indexPair = findRowColumn(nextNode, n);
                int row = indexPair[0];
                int column = indexPair[1];
                int destination = board[row][column] == -1 ? nextNode : board[row][column];
                if (distance[destination] == -1) {
                    distance[destination] = distance[currNode] + 1;
                    queue.add(destination);
                }
            }
        }
        return distance[n * n];
    }
    public int[] findRowColumn(int currNode, int n) {
        int row = n - 1 - (currNode - 1) / n;
        int column = (n - 1 - row) % 2 == 0 ? (currNode - 1) % n : n - 1 - ((currNode - 1) % n);
        return new int[]{row, column};
    }
    public static void main(String[] args) {
        int[][] board = {
                {-1, -1},
                {-1, 3},
        };
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        System.out.println(snakesAndLadders.snakesAndLadders(board));
    }
}
