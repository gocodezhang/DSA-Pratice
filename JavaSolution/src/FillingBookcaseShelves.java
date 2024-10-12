import java.util.Arrays;

public class FillingBookcaseShelves {
    public int minHeightShelves(int[][] books, int shelfWidth) {

        int[][] memo = new int[books.length][shelfWidth + 1];
        return dfs(0, books, shelfWidth, 0, 0, memo);
    }
    public int dfs(int i, int[][] books, int shelfWidth, int currWidth, int currHeight, int[][] memo) {
        // base case
        if (i == books.length) {
            return currHeight;
        }
        if (memo[i][currWidth] != 0) {
            return memo[i][currWidth];
        }

        // recursive case
        int[] currBook = books[i];
        int postWidth = currWidth + currBook[0];
        int height = Math.max(currBook[1], currHeight);
        if (postWidth > shelfWidth) {
            int result = currHeight + dfs(i + 1, books, shelfWidth, currBook[0], currBook[1], memo);
            memo[i][currWidth] = result;
            return result;
        } else {
            int same = dfs(i + 1, books, shelfWidth, postWidth, height, memo);
            int diff = currHeight + dfs(i + 1, books, shelfWidth, currBook[0], currBook[1], memo);

            int min = Math.min(same, diff);
            memo[i][currWidth] = min;

            return min;
        }
    }

    public int minHeightShelvesDP(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length + 1];

        dp[0] = 0;
        dp[1] = books[0][1];

        for (int i = 2; i <= books.length; i++) {
            int[] book = books[i - 1];
            dp[i] = book[1] + dp[i - 1];

            int height = book[1];
            int remainingWidth = shelfWidth - book[0];
            int j = i - 1;

            while (j > 0 && remainingWidth - books[j - 1][0] >= 0) {
                height = Math.max(height, books[j - 1][1]);
                remainingWidth = remainingWidth - books[j - 1][0];
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
                j--;
            }
        }

        return dp[books.length];
    }

    public static void main(String[] args) {
        int[][] books = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}}
                ;
        FillingBookcaseShelves fillingBookcaseShelves = new FillingBookcaseShelves();
        System.out.println(fillingBookcaseShelves.minHeightShelvesDP(books, 4));

    }
}
