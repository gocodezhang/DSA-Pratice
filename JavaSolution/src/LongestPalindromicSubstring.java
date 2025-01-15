public class LongestPalindromicSubstring {
    public String longestPalindromeBF(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (validate(i, j, s) && j - i > right - left) {
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left, right + 1);
    }
    public boolean validate(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public String longestPalindromeDP(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                left = i;
                right = i + 1;
            }
        }

        // we need to build from substring size small to larger
        for (int size = 2; size <= n; size++) {
            for (int i = 0; i < n - size; i++) {
                int j = i + size;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (j - i > right - left) {
                        left = i;
                        right = j;
                    }
                }
            }
        }

        return s.substring(left, right + 1);


    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindromeDP("aaaaa"));
    }

}
