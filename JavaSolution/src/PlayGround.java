import javax.swing.*;
import java.util.*;

public class PlayGround {
    public int maxProfit(int[] prices) {
        // global variable
        int totalProfit = 0;
        // left, right
        int left = 0;
        int right = 1;
        // go though arrays
        while (right < prices.length) {
            // left >= right; update window and do nothing
            if (prices[left] >= prices[right]) {
                left++;
                right++;
            } else {
                if (right == prices.length - 1 || prices[right] >= prices[right + 1]) {
                    totalProfit += prices[right] - prices[left];
                    left = right + 1;
                    right = left + 1;
                } else {
                    right++;
                }
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        PlayGround playGround = new PlayGround();
        System.out.println(playGround.maxProfit(nums));
    }
}
