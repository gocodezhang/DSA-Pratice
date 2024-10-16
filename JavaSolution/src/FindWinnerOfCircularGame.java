import java.util.LinkedList;
import java.util.List;

public class FindWinnerOfCircularGame {
    public int findTheWinner(int n, int k) {
        int start = 0;
        int remaining = n;
        int[] options = new int[n];

        while (remaining > 1) {
            int count = 1;

            while (count < k) {
                start = (start + 1) % n;
                if (options[start] == 0) {
                    count++;
                }
            }
            options[start] = -1;
            remaining--;

            while (options[start] == -1) {
                start = (start + 1) % n;
            }
        }

        return start + 1;
    }
    public static void main(String[] args) {
        FindWinnerOfCircularGame findWinnerOfCircularGame = new FindWinnerOfCircularGame();
        System.out.println(findWinnerOfCircularGame.findTheWinner(5, 2));
    }

}
