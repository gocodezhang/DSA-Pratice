import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        List<Integer> currList = new ArrayList<>();
        dfs(currList, nums, visited, result);

        return result;
    }

    private void dfs(List<Integer> currList, int[] nums, HashSet<Integer> visited, List<List<Integer>> result) {
        // base case
        if (currList.size() == nums.length) {
            result.add(new ArrayList<>(currList));
            return;
        }
        // recursive case
        for (int num : nums) {
            if (!visited.contains(num)) {
                currList.add(num);
                visited.add(num);
                dfs(currList, nums, visited, result);
                currList.remove((Integer) num);
                visited.remove((Integer) num);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(nums));
    }
}
