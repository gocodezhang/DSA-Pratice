import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BalancedStrWithKit {
    public int findMaximumScore(String s, String kitParentheses, int[] efficiencyRatings) {
        List<Integer> leftKit = new ArrayList<>();
        List<Integer> rightKit = new ArrayList<>();
        // split kis into left and right, then sort
        for (int i = 0; i < kitParentheses.length(); i++) {
            char currChar = kitParentheses.charAt(i);
            if (currChar == '(') {
                leftKit.add(efficiencyRatings[i]);
            } else {
                rightKit.add(efficiencyRatings[i]);
            }
        }
        Collections.sort(leftKit, (a, b) -> b - a);
        Collections.sort(rightKit, (a, b) -> b - a);
        // go through s and add kit

        int score = 0;
        int left = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '(') {
                stack.push(currChar);
                continue;
            }

            if (!stack.isEmpty()) {
                stack.pop();
            } else {
                score += leftKit.get(left);
                left++;
            }
        }

        int remainLeftInStack = stack.size();
        for (int right = 0; right < remainLeftInStack; right++) {
            score += rightKit.get(right);
        }
        // return score
        return score;
    }
    public static void main(String[] args) {
        String s1 = "))((()";
        String kitParentheses1 = ")(()))";
        int[] efficiencyRatings1 = {3, 4, 2, -4, -1, -3};

        BalancedStrWithKit balancedStrWithKit = new BalancedStrWithKit();
        System.out.println(balancedStrWithKit.findMaximumScore(s1, kitParentheses1, efficiencyRatings1));
    }
}
