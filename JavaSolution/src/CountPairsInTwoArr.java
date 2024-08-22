import java.util.Arrays;

public class CountPairsInTwoArr {
    public long countPairs(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] difference = new int[n];
        for (int i = 0; i < n; i++) {
            difference[i] = nums1[i] - nums2[i];
        }

        Arrays.sort(difference);

        int left = 0;
        int right = n - 1;
        long counter = 0;

        while (left < right) {
            int sum = difference[left] + difference[right];
            if (sum > 0) {
                counter += right - left;
                right--;
            } else {
                left++;
            }
        }
        return counter;
    }

    public static void main(String[] main) {
        int[] nums1 = {2, 1, 2, 1};
        int[] nums2 = {1, 2, 1, 2};
        CountPairsInTwoArr countPairsInTwoArr = new CountPairsInTwoArr();
        System.out.println(countPairsInTwoArr.countPairs(nums1, nums2));
    }
}
