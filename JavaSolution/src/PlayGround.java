import javax.swing.*;
import java.util.*;

public class PlayGround {
    public int removeElement(int[] nums, int val) {
        int insertIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        PlayGround playGround = new PlayGround();
        System.out.println();
    }
}
