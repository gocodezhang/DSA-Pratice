import java.util.*;

public class HandOfStraights {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        // sort the array
        Arrays.sort(hand);
        // create 1. currGroup 2. stack
        List<Integer> currGroup = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        // iterate through the array
        for (int i = 0; i < hand.length; i++) {
            int currHand = hand[i];
            // if ( currGroup is not empty)
            if (currGroup.size() > 0) {
                // if (last element + 1 = currElement)
                if (currGroup.get(currGroup.size() - 1) + 1 == currHand) {
                    currGroup.add(currHand);
                    if (currGroup.size() == groupSize) {
                        currGroup = new ArrayList<>();
                    }
                } else if (currGroup.get(currGroup.size() - 1) == currHand) {
                    stack.push(currHand);
                } else {
                    return false;
                }
            } else {
                if (!stack.empty() && stack.peek() + 1 == currHand) {
                    currGroup.add(stack.pop());
                }
                currGroup.add(currHand);
                if (currGroup.size() == groupSize) {
                    currGroup = new ArrayList<>();
                }
            }
        }

        // return currGroup && stack are empty
        return currGroup.size() == 0 && stack.empty();
    }
    public static boolean isNStraightHandSolution(int[] hand, int groupSize) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        Arrays.sort(hand);

        for (int i = 0; i < hand.length; i++) {
            if (countMap.get(hand[i]) == 0) {
                continue;
            }

            for (int j = 0; j < groupSize; j++) {
                int currCard = hand[i] + j;

                if (countMap.getOrDefault(currCard, 0) == 0) {
                    return false;
                }

                countMap.put(currCard, countMap.get(currCard) - 1);
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        System.out.println(isNStraightHandSolution(hand, groupSize));
    }
}
