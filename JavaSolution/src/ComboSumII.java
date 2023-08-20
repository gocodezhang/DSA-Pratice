import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComboSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> resultArr = new ArrayList<>();
        List<Integer> currCombo = new ArrayList<>();
        dfs(currCombo, resultArr, 0, 0,target, candidates);
        return resultArr;
    }
    public static void dfs(List<Integer> currCombo, List<List<Integer>> resultArr, int currSum, int index, int target,int[] candidates) {
        // base case
        // if (currSum > target)
        if (currSum > target) {
            return;
        }
        // return;
        // if (currSum == target)
        if (currSum == target) {
            resultArr.add(new ArrayList<>(currCombo));
            return;
        }

        // recursive case
        // for (i; i < nums.length; i++)
        for (int i = index; i < candidates.length; i++) {
            // if ( i == 0 || nums[i] != nums[i - 1])
            if (i == index || candidates[i] != candidates[i - 1]) {
                // update currCombo with ith element
                currCombo.add(candidates[i]);
                // update sum
                currSum += candidates[i];
                // call dfs
                dfs(currCombo, resultArr, currSum, i + 1, target, candidates);
                // remove ith element in currCombo and sum
                currCombo.remove(currCombo.size() - 1);
                currSum -= candidates[i];
            }
        }
    }
    public static void main(String[] args) {
        int [] arr = {2, 5, 2, 1, 2};
        int target = 5;
        System.out.println(combinationSum2(arr, target));
    }
}
