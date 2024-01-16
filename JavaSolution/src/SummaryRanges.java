import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0) {
            return ranges;
        }
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                String currRange = start == nums[i - 1] ? start + "" : start + "->" + nums[i - 1];
                ranges.add(currRange);
                start = nums[i];
            }
        }
        String lastRange = start == nums[nums.length - 1] ? start + "" : start + "->" + nums[nums.length - 1];
        ranges.add(lastRange);

        return ranges;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }
}
