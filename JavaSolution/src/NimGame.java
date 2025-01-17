public class NimGame {
    public boolean canWinNim(int n) {
        // perform dfs
        Boolean[][] memo = new Boolean[2][n + 1];
        return dfs(0, n, memo);
    }
    public boolean dfs(int player, int remaining, Boolean[][] memo) {
        // base case remaining <= 3
        if (remaining <= 3) {
            return true;
        }
        if (memo[player][remaining] != null) {
            return memo[player][remaining];
        }

        // recursive case
        // try option 1 - 3
        if (player == 0) {
            for (int take = 1; take <= 3; take++) {
                if (!dfs(1, remaining - take, memo)) {
                    memo[0][remaining] = true;
                    return true;
                }
            }
            memo[0][remaining] = false;
            return false;
        } else {
            for (int take = 1; take <= 3; take++) {
                if (!dfs(0, remaining - take, memo)) {
                    memo[0][remaining] = true;
                    return true;
                }
            }
            memo[0][remaining] = false;
            return false;
        }
    }
    public static void main(String[] args) {
        NimGame ng = new NimGame();
        System.out.println(ng.canWinNim(5));
    }

}
