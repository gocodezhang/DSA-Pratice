import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public boolean check(String s, List<String> wordDict) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(0, s, wordDict, memo);
    }
    public boolean dfs(int i, String s, List<String> wordDict, int[] memo) {
        if (i > s.length()) {
            return false;
        }
        if (i == s.length()) {
            return true;
        }
        if (memo[i] != -1) {
            return memo[i] == 1;
        }
        for (String word: wordDict) {
            int len = word.length();
            if (i + len <= s.length() && s.substring(i, i + len).equals(word) && dfs(i + len, s, wordDict, memo)) {
                return true;
            }
        }
        memo[i] = 0;
        return false;
    }
    public boolean checkIterative(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String word: wordDict) {
                if (i - word.length() + 1 < 0) {
                    continue;
                }
                dp[i] = (i - word.length() == -1 || dp[i - word.length()]) && s.substring(i - word.length() + 1, i + 1).equals(word);
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }
    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak.checkIterative(s, wordDict));
    }
}
