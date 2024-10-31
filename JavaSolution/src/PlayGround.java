import javax.swing.*;
import java.util.*;

public class PlayGround {

    public void rotate(int[] nums, int k) {
        int actualK = k % nums.length;
        int[] temp = new int[nums.length];

        int newHead = nums.length - actualK;
        int oldHead = 0;

        for (int i = 0; i < temp.length; i++) {
            if (newHead < temp.length) {
                temp[i] = nums[newHead];
                newHead++;
            } else {
                temp[i] = nums[oldHead];
                oldHead++;
            }
        }

        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        PlayGround playGround = new PlayGround();
        playGround.rotate(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
