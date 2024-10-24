import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class MaximumScoreFromRemovingSubstrings {
    String target1 = "ab";
    String target2 = "ba";
    public int maximumGain(String s, int x, int y) {

        HashMap<String, Integer> memo = new HashMap<>();

        return dfs(s, x, y, memo);
    }
    public int dfs(String s, int x, int y, HashMap<String, Integer> memo) {
        // base case
        if (s.length() == 0) {
            return 0;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        // recursive case
        int result = 0;
        // find all possible options
        List<Integer> abs = findTargets(s, "ab");
        List<Integer> bas = findTargets(s, "ba");
        // perform recursive call
        for (int i = 0; i < abs.size(); i++) {
            int start = abs.get(i);
            int curr = x + dfs(s.substring(0, start) + s.substring(start + 2), x, y, memo);
            result = Math.max(result, curr);
        }
        for (int i = 0; i < bas.size(); i++) {
            int start = bas.get(i);
            int curr = y + dfs(s.substring(0, start) + s.substring(start + 2), x, y, memo);
            result = Math.max(result, curr);
        }

        memo.put(s, result);

        return result;
    }
    public List<Integer> findTargets(String s, String target) {
        List<Integer> result = new ArrayList<>();

        int searchIndex = 0;
        while (searchIndex < s.length() && s.indexOf(target, searchIndex) != -1) {
            int index = s.indexOf(target, searchIndex);
            result.add(index);
            searchIndex = index + 1;
        }

        return result;
    }

    public int maximumGainGreedy(String s, int x, int y) {
        int score = 0;
        if (x > y) {
            String remainingAfterX = removeAll(s, "ab");
            score += (s.length() - remainingAfterX.length()) / 2 * x;
            String remainingAfterY = removeAll(remainingAfterX, "ba");
            score += (remainingAfterX.length() - remainingAfterY.length()) / 2 * y;
        } else {
            String remainingAfterY = removeAll(s, "ba");
            score += (s.length() - remainingAfterY.length()) / 2 * y;
            String remainingAfterX = removeAll(remainingAfterY, "ab");
            score += (remainingAfterY.length() - remainingAfterX.length()) / 2 * x;
        }

        return score;
    }
    private String removeAll(String s, String target) {
        char targetChar = target.charAt(1);
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == targetChar && !stack.isEmpty() && stack.peek() == target.charAt(0)) {
                stack.pop();
            } else {
                stack.add(currChar);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char remain : stack) {
            builder.append(remain);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        MaximumScoreFromRemovingSubstrings maximumScoreFromRemovingSubstrings = new MaximumScoreFromRemovingSubstrings();
        System.out.println(maximumScoreFromRemovingSubstrings.maximumGainGreedy(s, 4, 5));
    }


}
