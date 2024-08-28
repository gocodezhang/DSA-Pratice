import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int largest = 0;
        for (int c : dp) {
            largest = Math.max(c, largest);
        }

        return largest;
    }
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (sub.get(sub.size() - 1) < nums[i]) {
                sub.add(nums[i]);
            } else {
                int num = nums[i];
                int j = 0;
                while (sub.get(j) < num) {
                    j++;
                }
                sub.set(j, num);
            }
        }
        return sub.size();
    }
    public int lengthOfLIS3(int[] nums) {
        int n = nums.length;
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (sub.get(sub.size() - 1) < nums[i]) {
                sub.add(nums[i]);
            } else {
                int num = nums[i];
                int left = 0; int right = sub.size() - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (sub.get(mid) < num) {
                        left = mid + 1;
                    } else if (sub.get(mid) > num) {
                        right = mid;
                    } else {
                        left = mid;
                        break;
                    }
                }
                sub.set(left, num);
            }
        }
        return sub.size();
    }
}
