import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    List<List<Integer>> allCombos;
    int range;
    int numPerCombo;
    public List<List<Integer>> combine(int n, int k) {
        this.allCombos = new ArrayList<>();
        this.range = n;
        this.numPerCombo = k;
        List<Integer> currCombo = new LinkedList<>();
        dfs(0, currCombo);
        return allCombos;
    }
    public void dfs(int index, List<Integer> currCombo) {
        // base case
        if (currCombo.size() == numPerCombo) {
            allCombos.add(new ArrayList<>(currCombo));
            return;
        }
        // if (index == n)
        if (index == range) {
            return;
        }

        // recursive case
        for (int i = index + 1; i <= range; i++) {
            currCombo.add(i);
            dfs(i, currCombo);
            currCombo.remove(currCombo.size() - 1);
        }
    }
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(n, k));
    }
}
