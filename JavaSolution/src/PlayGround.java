import javax.swing.*;
import java.util.*;

public class PlayGround {

    public int removeDuplicates(int[] nums) {
        int prev = nums[0];
        int count = 1;
        int insertIndex = 1;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (prev != curr) {
                nums[insertIndex] = curr;
                count = 1;
                insertIndex++;
            } else {
                if (count < 2) {
                    nums[insertIndex] = curr;
                    insertIndex++;
                }
                count++;
            }
            prev = curr;
        }

        return insertIndex;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        PlayGround playGround = new PlayGround();
        System.out.println();
    }
}
