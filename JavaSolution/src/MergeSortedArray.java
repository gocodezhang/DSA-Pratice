import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int left = 0;
        int right = 0;
        while (left < m && right < n) {
            if (nums1[left] <= nums2[right]) {
                result[left + right] = nums1[left];
                left++;
            } else {
                result[left + right] = nums2[right];
                right++;
            }
        }
        while (left < m) {
            result[left + right] = nums1[left];
            left++;
        }
        while (right < n) {
            result[left + right] = nums2[right];
            right++;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = result[i];
        }
    }
    public static void mergerOptimal(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1;
        int pointer2 = n - 1;
        while (pointer1 >= 0 && pointer2 >= 0) {
            if (nums1[pointer1] < nums2[pointer2]) {
                nums1[pointer1 + pointer2 + 1] = nums2[pointer2];
                pointer2--;
            } else {
                nums1[pointer1 + pointer2 + 1] = nums1[pointer1];
                pointer1--;
            }
        }
        while (pointer1 >=0) {
            nums1[pointer1 + pointer2 + 1] = nums1[pointer1];
            pointer1--;
        }
        while (pointer2 >=0) {
            nums1[pointer1 + pointer2 + 1] = nums2[pointer2];
            pointer2--;
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        mergerOptimal(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
