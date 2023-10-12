import java.util.ArrayList;
import java.util.List;

public class RemoveElement {
    public static int removeNumber(int[] nums, int val) {
        List<Integer> notEqualVal = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                notEqualVal.add(nums[i]);
            }
        }
        for (int i = 0; i < notEqualVal.size(); i++) {
            nums[i] = notEqualVal.get(i);
        }
        return notEqualVal.size();
    }
    public static int removeNumberOptimal(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
