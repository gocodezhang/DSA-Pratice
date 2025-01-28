import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] result = new int[queries.length];
        // go through query
        for (int i = 0; i < queries.length; i++) {
            // given the range
            int[] query = queries[i];
            // find # plates
            result[i] = countPlates(s, query[0], query[1]);
        }

        // return count
        return result;
    }
    public int countPlates(String s, int left, int right) {
        int count = 0;
        int leftCandle = -1;
        for (int rightCandle = left; rightCandle <= right; rightCandle++) {
            if (s.charAt(rightCandle) == '|') {
                if (leftCandle != -1) {
                    count += rightCandle - leftCandle - 1;
                }
                leftCandle = rightCandle;
            }
        }
        return count;
    }
    public int[] platesBetweenCandlesArrays(String s, int[][] queries) {
        // rightCandles - close candle to its right
        // leftCandles
        // countPlates (left to right)
        int n = s.length();
        int[] rightCandles = new int[n];
        int[] leftCandles = new int[n];
        int[] countPlates = new int[n];

        if (s.charAt(0) == '|') {
            leftCandles[0] = 0;
        } else {
            leftCandles[0] = -1;
            countPlates[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            countPlates[i] = countPlates[i - 1];
            leftCandles[i] = leftCandles[i - 1];
            if (s.charAt(i) == '|') {
                leftCandles[i] = i;
            } else {
                countPlates[i] = countPlates[i] + 1;
            }
        }
        if (s.charAt(n - 1) == '|') {
            rightCandles[n - 1] = n - 1;
        } else {
            rightCandles[n - 1] = -1;
        }
        for (int i = n - 2; i >= 0; i--) {
            rightCandles[i] = rightCandles[i + 1];
            if (s.charAt(i) == '|') {
                rightCandles[i] = i;
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int leftBound = rightCandles[query[0]];
            int rightBound = leftCandles[query[1]];

            if (leftBound != -1 && rightBound != -1 && rightBound > leftBound) {
                result[i] = (countPlates[rightBound] - countPlates[leftBound]);
            } else {
                result[i] = 0;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "**|**|***|";
        int[][] queries = {{2,5}, {5,9}};
        PlatesBetweenCandles pc = new PlatesBetweenCandles();
        System.out.println(Arrays.toString(pc.platesBetweenCandlesArrays(s, queries)));
    }
}
