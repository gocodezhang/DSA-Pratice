import java.util.Stack;

public class ValidParenthesisString {
    public static boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '(') {
                leftMin += 1;
            } else {
                leftMin -= 1;
            }
            leftMin = Math.max(leftMin, 0);

            if (currChar != ')') {
                leftMax += 1;
            } else {
                leftMax -= 1;
            }

            if (leftMax < 0) {
                return false;
            }
        }
        return leftMin == 0;
    }
    public static void main(String[] args) {
         String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(";
         System.out.println(checkValidString(s));
    }
}
