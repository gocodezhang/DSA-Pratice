import java.util.Arrays;

public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(word1, 0, word2, 0, memo);
    }
    public static int dfs(String word1, int i, String word2, int j, int[][] memo) {
        if (j >= word2.length()) {
            return word1.length() - i;
        }
        if (i >= word1.length()) {
            return word2.length() - j;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int miniDistance;
        if (word1.charAt(i) == word2.charAt(j)) {
            miniDistance = dfs(word1, i + 1, word2, j + 1, memo);
        } else {
            int insert = dfs(word1, i, word2, j + 1, memo) + 1;
            int delete = dfs(word1, i + 1, word2, j, memo) + 1;
            int replace = dfs(word1, i + 1, word2, j + 1, memo) + 1;
            miniDistance = Math.min(Math.min(insert, delete), replace);
        }
        memo[i][j] = miniDistance;
        return miniDistance;
    }
    public static int minDistanceIterative(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return word1.length() + word2.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            if (i == 0) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }
        for (int i = 1; i < word2.length() + 1; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j -1];
                } else {
                    int currMin = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    dp[i][j] = currMin + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
    public static void main(String[] args) {
        String word1 = "zoologicoarchaeologist";
        String word2 = "zoogeologist";
        System.out.println(minDistanceIterative(word1, word2));
    }
}
