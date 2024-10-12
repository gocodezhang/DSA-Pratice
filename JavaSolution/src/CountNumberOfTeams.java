public class CountNumberOfTeams {
    public int numTeams(int[] rating) {
        int count = 0;
        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if (rating[i] < rating[j] && rating[j] < rating[k]) {
                        count++;
                    }
                    if (rating[i] > rating[j] && rating[j] > rating[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public int numTeamsMiddlePoint(int[] rating) {
        int count = 0;
        for (int i = 0; i < rating.length; i++) {
            int numOfLargerLeft = 0;
            int numOfSmallerLeft = 0;
            int num = rating[i];
            for (int left = i - 1; left >= 0; left--) {
                if (num > rating[left]) {
                    numOfLargerLeft++;
                }
                if (num < rating[left]) {
                    numOfSmallerLeft++;
                }
            }

            int numOfLargerRight = 0;
            int numOfSmallerRight = 0;
            for (int right = i + 1; right < rating.length; right++) {
                if (num > rating[right]) {
                    numOfLargerRight++;
                }
                if (num < rating[right]) {
                    numOfSmallerRight++;
                }
            }
            count += numOfLargerLeft * numOfSmallerRight + numOfSmallerLeft * numOfLargerRight;
        }

        return count;
    }

    public int numTeamsDFS(int[] rating) {
        int[][] memo = new int[rating.length][4];
        int result = 0;
        for (int i = 0; i <= rating.length - 3; i++) {
            result += findIncreasingGroups(i, 1, rating, memo);
        }
        memo = new int[rating.length][4];
        for (int i = 0; i <= rating.length - 3; i++) {
            result += findDecreasingGroups(i, 1, rating, memo);
        }
        return result;
    }
    public int findIncreasingGroups(int i, int currSize, int[] rating, int[][] memo) {
        // base case
        if (currSize > 3) {
            return 0;
        }
        if (currSize == 3) {
            return 1;
        }
        if (memo[i][currSize] != 0) {
            return memo[i][currSize];
        }

        // recursive case
        int sum = 0;
        for (int nextIndex = i + 1; nextIndex < rating.length; nextIndex++) {
            if (rating[nextIndex] > rating[i]) {
                sum += findIncreasingGroups(nextIndex, currSize + 1, rating, memo);
            }
        }
        memo[i][currSize] = sum;
        return sum;
    }
    public int findDecreasingGroups(int i, int currSize, int[] rating, int[][] memo) {
        // base case
        if (currSize > 3) {
            return 0;
        }
        if (currSize == 3) {
            return 1;
        }
        if (memo[i][currSize] != 0) {
            return memo[i][currSize];
        }

        // recursive case
        int sum = 0;
        for (int nextIndex = i + 1; nextIndex < rating.length; nextIndex++) {
            if (rating[nextIndex] < rating[i]) {
                sum += findDecreasingGroups(nextIndex, currSize + 1, rating, memo);
            }
        }
        memo[i][currSize] = sum;
        return sum;
    }

    public int numTeamsDP(int[] rating) {
        int[][] increasingDP = new int[rating.length][4];
        int[][] decreasingDP = new int[rating.length][4];
        for (int i = 0; i < rating.length; i++) {
            increasingDP[i][1] = 1;
            decreasingDP[i][1] = 1;

            int indexBackward = i - 1;
            while (indexBackward >= 0) {
                if (rating[indexBackward] < rating[i]) {
                    increasingDP[i][2] += increasingDP[indexBackward][1];
                    increasingDP[i][3] += increasingDP[indexBackward][2];
                }
                if (rating[indexBackward] > rating[i]) {
                    decreasingDP[i][2] += decreasingDP[indexBackward][1];
                    decreasingDP[i][3] += decreasingDP[indexBackward][2];
                }
                indexBackward--;

            }

        }
        int result = 0;
        for (int i = 0; i < rating.length; i++) {
            result += increasingDP[i][3] + decreasingDP[i][3];
        }

        return result;
    }
    public static void main(String[] args) {
        int[] rating = {2,5,3,4,1};
        CountNumberOfTeams countNumberOfTeams = new CountNumberOfTeams();
        System.out.println(countNumberOfTeams.numTeamsDP(rating));
    }
}
