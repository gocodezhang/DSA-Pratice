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
        if (i >= nums.length) {
            if (!resArr.contains(currSet)) {
                resArr.add(new ArrayList<>(currSet));
            }
            return;
        }
        // when yes,
        // check if currSet exist in resArr
        // if no, add currSet in resArr
        // return

        // recursive case
        // add ith element in currSet
        currSet.add(nums[i]);
        // dfs(i + 1);
        dfs(i + 1, nums, currSet, resArr);
        // pop ith element in currSet
        currSet.remove(currSet.size() - 1);
        // dfs(i + 1)
        dfs(i + 1, nums, currSet, resArr);

    }

    public static void main(String[] args) {
        int[] nums = {4,1,4};
        System.out.println(subsetsWithDup(nums));
    }
}
