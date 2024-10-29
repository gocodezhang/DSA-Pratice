import javax.swing.*;
import java.util.*;

public class PlayGround {

    public int majorElement(int[] nums) {
        int major = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (major == curr) {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                major = curr;
                count = 1;
            }
        }
        return major;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        PlayGround playGround = new PlayGround();
        System.out.println();
    }
}
