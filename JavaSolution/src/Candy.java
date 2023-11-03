import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Candy {
    public static int countMinCandy(int[] ratings) {
        // create array called candies (filled with 1)
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        // go through ratings and find the vallies
        // vallies arrays
        List<Integer> valley = new ArrayList<>();
        // for i < ratings.length; i++
        for (int i = 0; i < ratings.length; i++) {
            // i > 0 && ratings[i - 1] > ratings[i] || i < ratings.length - 1 && ratings[i] < ratingss[i + 1]
            boolean condition1 = i > 0 && ratings[i - 1] > ratings[i] && (i == ratings.length - 1 || ratings[i] <= ratings[i + 1]);
            boolean condition2 = i < ratings.length - 1 && ratings[i] < ratings[i + 1] && (i == 0 || ratings[i] <= ratings[i - 1]);
            if (condition1 || condition2) {
                valley.add(i);
            }
        }


        //start search from every vallies
        // for i < vailles.length; i++
        for (int i = 0; i < valley.size(); i++) {
            // left = vallies[i]
            int left = valley.get(i);
            // while (left > 0 && ratings[left - 1] > ratings[left])
            while (left > 0 && ratings[left - 1] > ratings[left]) {
                // if (candies[left - 1] == candies[left]
                if (candies[left - 1] <= candies[left]) {
                    candies[left - 1] = candies[left] + 1;
                }
                // left--
                left--;
            }

            // right = vallies[i]
            int right = valley.get(i);
            // while (left > 0 && ratings[left - 1] > ratings[left])
            while (right < ratings.length - 1 && ratings[right] < ratings[right + 1]) {
                // if (candies[left - 1] == candies[left]
                if (candies[right] >= candies[right + 1]) {
                    candies[right + 1] = candies[right] + 1;
                }
                // right++
                right++;
            }
        }

        // count the candies
        return Arrays.stream(candies).sum();
    }
    public static int countMinCandyTwoArray(int[] ratings) {
        int[] left = new int[ratings.length];
        Arrays.fill(left, 1);
        int[] right = new int[ratings.length];
        Arrays.fill(right, 1);
        for (int i = 1; i < left.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = right.length - 2; i >=0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
    public static int countMinCandyOptimal(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int candies = 0;
        int up = 0;
        int down = 0;
        int oldSlope = 0;
        for (int i = 1; i < ratings.length; i++) {
            int newSlope = (ratings[i] > ratings[i - 1]) ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);

            if ((oldSlope > 0 && newSlope == 0) || (oldSlope < 0 && newSlope >= 0)) {
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (newSlope > 0) {
                up++;
            } else if (newSlope < 0) {
                down++;
            } else {
                candies++;
            }

            oldSlope = newSlope;
        }
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }
    public static int count(int n) {
        return n * (n + 1) / 2;
    }
    public static void main(String[] args) {
        int[] ratings = {1,2,87,87,2,1};
        System.out.println(countMinCandyOptimal(ratings));
    }
}
