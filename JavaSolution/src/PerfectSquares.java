import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int result = Integer.MAX_VALUE;
        int maxSqrt = (int) Math.floor(Math.sqrt(n));
        for (int i = maxSqrt; i >= 1; i--) {
            int count = n / (i * i);
            int option = count + numSquares(n - count * (i * i));
            result = Math.min(result, option);
        }

        return result;
    }
    public int numSquaresDP(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int sqrt = 1; sqrt * sqrt <= i; sqrt++) {

                dp[i] = Math.min(dp[i], dp[i - sqrt * sqrt] + 1);

            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        System.out.println(ps.numSquaresDP(12));
    }
}
