import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> combinations = new ArrayList<>();
    public List<List<Integer>> findAllCombinations(int[] candidates, int target) {
        List<Integer> currCombo = new ArrayList<>();
        dfs(0, currCombo, candidates, target);
        return combinations;
    }
    public void dfs(int index, List<Integer> currCombo,int[] candidates, int remaining) {
        // base case
        if (remaining < 0) {
            return;
        }
        if (remaining == 0) {
            List<Integer> copyCurrCombo = new ArrayList<>(currCombo);
            combinations.add(copyCurrCombo);
            return;
        }
        // recursive case
        for (int i = 0; i < candidates.length; i++) {
            if (index > i) {
                continue;
            }
            int candidate = candidates[i];
            currCombo.add(candidate);
            dfs(i, currCombo, candidates, remaining - candidate);
            currCombo.remove(currCombo.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.findAllCombinations(candidates, target));
    }
}
