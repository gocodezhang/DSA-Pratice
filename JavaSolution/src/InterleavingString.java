import java.util.Arrays;

public class InterleavingString {
    public static boolean isInterLeave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int[][] memo = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(s1, 0, s2, 0, s3, 0, memo);
    }
    public static boolean dfs(String input1, int i, String input2, int j, String target, int k, int[][] memo) {
        if (k == target.length()) {
            return true;
        }
        if (i == input1.length()) {
            return input2.substring(j).equals(target.substring(k));
        }
        if (j == input2.length()) {
            return input1.substring(i).equals(target.substring(k));
        }
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        boolean option1 = false, option2 = false;
        if (input1.charAt(i) == target.charAt(k)) {
            option1 = dfs(input1, i + 1, input2, j, target, k + 1, memo);
        }
        if (input2.charAt(j) == target.charAt(k)) {
            option2 = dfs(input1, i, input2, j + 1, target, k + 1, memo);
        }
        if (option1 || option2) {
            memo[i][j] = 1;
        } else {
            memo[i][j] = 0;
        }
        return option1 || option2;
    }
    public static boolean isInterLeaveIterative(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[s1.length()][s2.length()] = 1;
        for (int i = 0; i < s1.length() + 1; i++) {
            if (i == s1.length()) {
                continue;
            }
            if (s1.substring(i).equals(s3.substring(s2.length() + i))) {
                dp[i][s2.length()] = 1;
            }
        }
        for (int i = 0; i < s2.length() + 1; i++) {
            if (i == s2.length()) {
                continue;
            }
            if (s2.substring(i).equals(s3.substring(s1.length() + i))) {
                dp[s1.length()][i] = 1;
            }
        }
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >=0; j--) {
                if (dp[i + 1][j] == 1 && s1.charAt(i) == s3.charAt(i + j)) {
                    dp[i][j] = 1;
                }
                if (dp[i][j + 1] == 1 && s2.charAt(j) == s3.charAt(i + j)) {
                    dp[i][j] = 1;
                }
            }
        }
        return dp[0][0] == 1;
    }
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        System.out.println(isInterLeaveIterative(s1, s2, s3));
    }
}
