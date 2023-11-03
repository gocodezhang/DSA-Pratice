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
            if ((i > 0 && ratings[i - 1] > ratings[i]) || (i < ratings.length - 1 && ratings[i] < ratings[i + 1])) {
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
    public static void main(String[] args) {
        int[] ratings = {1,2,87,87,87,2,1};
        System.out.println(countMinCandy(ratings));
    }
}
