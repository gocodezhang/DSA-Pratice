import java.util.*;

public class HandOfStraights {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            int currFrequency = map.getOrDefault(hand[i], 0);
            currFrequency++;
            map.put(hand[i], currFrequency);
        }
        Arrays.sort(hand);

        for (int i = 0; i < hand.length; i++) {
            int currHand = hand[i];
            if (map.get(currHand) == 0) {
                continue;
            }

            for (int j = 0; j < groupSize; j++) {
                if (map.getOrDefault(currHand + j, 0) == 0) {
                    return false;
                }
                int currFrequency = map.get(currHand + j);
                map.put(currHand + j, currFrequency - 1);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] hand = {1,2,3,4,5};
        int groupSize = 4;
        System.out.println(isNStraightHand(hand, groupSize));
    }
}
