import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int numOfBoats = 0;

        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            if (left == right || people[right] + people[left] > limit) {
                numOfBoats++;
                right--;
            } else {
                numOfBoats++;
                left++;
                right--;
            }
        }

        return numOfBoats;
    }
}
