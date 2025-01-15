import java.util.HashSet;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int number = 0;
        while (number <= nums.length) {
            if (!set.contains(number)) {
                return number;
            }
            number++;
        }

        return -1;
    }
}
