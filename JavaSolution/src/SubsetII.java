import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        // create resArr = [];
        List<List<Integer>> resArr = new ArrayList<>();
        // create currSet = [];
        List<Integer> currSet = new ArrayList<Integer>();
        dfs(0, nums, currSet, resArr);

        // return resArr
        return resArr;
    }

    public static void dfs(Integer i, int[] nums, List<Integer> currSet, List<List<Integer>> resArr) {
        resArr.add(new ArrayList<>(currSet));
        for (int j = i; j < nums.length; j++) {
            if (j != i && nums[j] == nums[j - 1]) {
                continue;
            }
            currSet.add(nums[j]);
            dfs(j + 1, nums, currSet, resArr);
            currSet.remove(currSet.size() - 1);

        }

    }

    public static void main(String[] args) {
        int[] nums = {4,1, 4};
        System.out.println(subsetsWithDup(nums));
    }
}
