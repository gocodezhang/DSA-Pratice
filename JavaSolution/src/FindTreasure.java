import java.util.Arrays;

/**
 We are playing a game where the player needs to follow instructions to find a treasure.
 There are multiple rooms, aligned in a straight line, labeled sequentially from 0. Each room contains one instruction, given as a positive integer.
 An instruction directs the player to move forward a specific number of rooms. The last instruction is "9" by convention, and can be ignored (there's no room to move after the last room).
 The player starts the game in room number 0 and has to reach the treasure which is in the last room. The player is given an amount of money to start the game with. She must use this money wisely to get to the treasure as fast as possible.

 The player can follow the instruction or pay $1 to change the value of the instruction by one. For example, for $1, the instruction "2" may be changed to "1" or "3". A player cannot pay more than $1 to change the value of an instruction by more than one unit.

 Write a function that takes a list of instructions and a total amount of money as input and returns the minimum number of instructions needed to reach the treasure room, or None/null/-1 if the treasure cannot be reached.

 Examples
 Note: The updated instructions are marked with *.

 Example 1

 instructions_2_1 =  [1, 1, 1, 9]

 With $0, the player would follow 3 instructions:
 Instructions:   [  1,  1,  1,  9]
 Itinerary:      [  1,  1,  1,  9]
 ^   ^   ^   ^

 With $1, the player would reach the treasure in 2 instructions: she could change, for example, the first instruction to 2.
 Instructions:   [  1,  1,  1,  9]
 Itinerary:      [ *2,  1,  1,  9]
 ^       ^   ^

 Example 2

 instructions_2_2 = [1, 1, 2, 9]

 With $0 as the initial amount, the treasure is not reachable.

 With $1 (or more) as the initial amount, the treasure can be reached in 2 instructions.
 Instructions:   [  1,  1,  2,  9]
 Itinerary:      [  1, *2,  2,  9]
 ^   ^       ^

 Example 3

 instructions_2_3  =  [1, 3, 1, 1, 1, 3, 10, 9]

 With $0, the treasure cannot be reached
 Instructions:   [  1,  3,  1,  1,  1,  3,  10,  9]
 Itinerary:      [  1,  3,  1,  1,  1,  3,  10,  9]
 ^   ^           ^   ^        x

 With $1, the treasure can be found in 4 instructions:
 Instructions:   [  1,  3,  1,  1,  1,  3,  10,  9]
 Itinerary:      [  1,  3,  1,  1,  1, *2,  10,  9]
 ^   ^           ^   ^        ^

 With $2,the treasure can be found in 3 instructions:
 Instructions:   [  1,  3,  1,  1,  1,  3,  10,  9]
 Itinerary:      [  1, *4,  1,  1,  1, *2,  10,  9]
 ^   ^               ^        ^

 All the test cases:

 instructions_2_1 = [1, 1, 1, 9]
 instructions_2_2 = [1, 1, 2, 9]
 instructions_2_3 = [1, 3, 1, 1, 1, 3, 10, 9]

 find_treasure(instructions_2_1, 0) => 3
 find_treasure(instructions_2_1, 1) => 2

 find_treasure(instructions_2_2, 0) => None or Null
 find_treasure(instructions_2_2, 1) => 2
 find_treasure(instructions_2_2, 2) => 2

 find_treasure(instructions_2_3, 0) => None or Null
 find_treasure(instructions_2_3, 1) => 4
 find_treasure(instructions_2_3, 2) => 3
 */
public class FindTreasure {
    public Integer findTreasure(int[] instructions, int money) {
        int[][] memo = new int[instructions.length][money + 1];
        for (int i = 0; i < instructions.length; i++) {
            int[] row = memo[i];
            Arrays.fill(row, -1);
        }
        int result = dfs(0, instructions, money, memo);

        return result == Integer.MAX_VALUE ? null : result;
    }
    private int dfs(int i, int[] instructions, int remaining, int[][] memo) {
        // base case
        if (i >= instructions.length) {
            return Integer.MAX_VALUE;
        }
        if (i == instructions.length - 1) {
            return 0;
        }
        if (memo[i][remaining] != -1) {
            return memo[i][remaining];
        }

        // recursive case
        int originalNext = i + instructions[i];
        int result = Integer.MAX_VALUE;

        int woPay = dfs(originalNext, instructions, remaining, memo);
        result = Math.min(result, woPay);

        if (remaining > 0) {
            int payToIncrease = dfs(originalNext + 1, instructions, remaining - 1, memo);
            int payToDecrease = dfs(originalNext - 1, instructions, remaining - 1, memo);
            result = Math.min(result, payToDecrease);
            result = Math.min(result, payToIncrease);
        }

        memo[i][remaining] = result == Integer.MAX_VALUE ? result : result + 1;

        return memo[i][remaining];

    }
    public Integer findTreasureDp(int[] instructions, int money) {
        Integer[][] dp = new Integer[instructions.length][money + 1];
        Arrays.fill(dp[instructions.length - 1], 0);

        for (int i = instructions.length - 2; i >= 0; i--) {
            int step = instructions[i];
            for (int remaining = 0; remaining <= money; remaining++) {
                if (i + step < instructions.length && dp[i + step][remaining] != null) {
                    dp[i][remaining] = findMinInteger(dp[i][remaining], dp[i + step][remaining] + 1);
                }
                if (remaining > 0) {
                    if (i + step + 1 < instructions.length && dp[i + step + 1][remaining - 1] != null) {
                        dp[i][remaining] = findMinInteger(dp[i][remaining], dp[i + step + 1][remaining - 1] + 1);
                    }
                    if (step - 1 > 0 && i + step - 1 < instructions.length && dp[i + step - 1][remaining - 1] != null) {
                        dp[i][remaining] = findMinInteger(dp[i][remaining], dp[i + step - 1][remaining - 1] + 1);
                    }
                }
            }
        }

        return dp[0][money];
    }
    private Integer findMinInteger(Integer a, Integer b) {
        if (a == null && b == null) {
            return null;
        } else if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        } else {
            return Math.min(a, b);
        }
    }
    public static void main(String[] args) {
        FindTreasure findTreasure = new FindTreasure();
        int[] instructions_2_1 = {1, 1, 1, 9};
        int[] instructions_2_2 = {1, 1, 2, 9};
        int[] instructions_2_3 = {1, 3, 1, 1, 1, 3, 10, 9};

        System.out.println(findTreasure.findTreasureDp(instructions_2_1, 0));
        System.out.println(findTreasure.findTreasureDp(instructions_2_1, 1));

        System.out.println(findTreasure.findTreasureDp(instructions_2_2, 0));
        System.out.println(findTreasure.findTreasureDp(instructions_2_1, 1));
        System.out.println(findTreasure.findTreasureDp(instructions_2_2, 2));

        System.out.println(findTreasure.findTreasureDp(instructions_2_3, 0));
        System.out.println(findTreasure.findTreasureDp(instructions_2_3, 1));
        System.out.println(findTreasure.findTreasureDp(instructions_2_3, 2));

//        find_treasure(instructions_2_1, 0) => 3
//        find_treasure(instructions_2_1, 1) => 2
//
//        find_treasure(instructions_2_2, 0) => None or Null
//        find_treasure(instructions_2_2, 1) => 2
//        find_treasure(instructions_2_2, 2) => 2
//
//        find_treasure(instructions_2_3, 0) => None or Null
//        find_treasure(instructions_2_3, 1) => 4
//        find_treasure(instructions_2_3, 2) => 3
    }
}
