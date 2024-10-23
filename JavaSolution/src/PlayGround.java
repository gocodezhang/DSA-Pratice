import javax.swing.*;
import java.util.*;

public class PlayGround {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1;
        int pointer2 = n - 1;
        int insertIndex = m + n - 1;

        while (pointer2 >= 0 && pointer1 >= 0) {
            if (nums1[pointer1] > nums2[pointer2]) {
                nums1[insertIndex] = nums1[pointer1];
                pointer1--;
            } else {
                nums1[insertIndex] = nums2[pointer2];
                pointer2--;
            }
            insertIndex--;
        }

        while (pointer2 >= 0) {
            nums1[insertIndex] = nums2[pointer2];
            insertIndex--;
            pointer2--;
        }

    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        PlayGround playGround = new PlayGround();
        System.out.println();
    }
}
