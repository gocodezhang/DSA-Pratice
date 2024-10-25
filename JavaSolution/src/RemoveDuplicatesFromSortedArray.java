import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                list.add(nums[i]);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return list.size();
    }
    public int removeDuplicatesOptimal(int[] nums) {
        int prev = nums[0];
        int insertIndex = 1;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (prev != curr) {
                nums[insertIndex] = curr;
                insertIndex++;
            }

            prev = curr;
        }

        return insertIndex;
    }
}
