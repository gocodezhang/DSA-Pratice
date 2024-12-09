import javax.swing.*;
import java.util.*;

public class PlayGround {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] assigns = new int[n];
        // check the left neigbhors
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                assigns[i] = 1;
                continue;
            }
            if (ratings[i - 1] >= ratings[i]) {
                assigns[i] = 1;
            } else {
                assigns[i] = assigns[i - 1] + 1;
            }
        }
        // check the right neigbhors
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && assigns[i] <= assigns[i + 1]) {
                assigns[i] = assigns[i + 1] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += assigns[i];
        }

        return sum;
    }

    public int candySlope(int[] ratings) {
        int up = 0;
        int down = 0;
        int prevSlope = 0;

        int sum = 0;

        for (int i = 1; i < ratings.length; i++) {
            int newSlope = findSlope(ratings[i - 1], ratings[i]);

            if ((prevSlope == -1 && newSlope >= 0) || (prevSlope == 1 && newSlope == 0)) {
                sum += calculate(up, down);
                up = 0;
                down = 0;
            }
            if (newSlope == -1) {
                down++;
            } else if (newSlope == 1) {
                up++;
            } else {
                sum++;
            }
            prevSlope = newSlope;
        }
        sum += calculate(up, down) + 1;

        return sum;
    }
    public int findSlope(int a, int b) {
        if (a < b) {
            return 1;
        } else if (a > b) {
            return -1;
        } else {
            return 0;
        }
    }
    public int calculate(int up, int down) {
        if (up >= down) {
            int peak = up + 1;
            return peak * (peak + 1) / 2 + down * (down + 1) / 2 - 1;
        } else {
            int peak = down + 1;
            return peak * (peak + 1) / 2 + up * (up + 1) / 2 - 1;
        }
    }



    public static void main(String[] args) {
        PlayGround playground = new PlayGround();
        int[] nums = {1, 2, 2};
        System.out.println(playground.candySlope(nums));

    }
}
