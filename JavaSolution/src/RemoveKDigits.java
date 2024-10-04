import java.util.Stack;

public class RemoveKDigits {
    public String removeKDigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        // create increasing stack
        Stack<Character> increasingStack = new Stack<>();
        int digitsRemoved = 0;
        // go through the num
        for (int i = 0; i < num.length(); i++) {
            char currDigit = num.charAt(i);
            while (!increasingStack.isEmpty() && (increasingStack.peek() - '0') > (currDigit - '0') && digitsRemoved < k) {
                increasingStack.pop();
                digitsRemoved++;
            }
            increasingStack.push(currDigit);
        }

        while (digitsRemoved < k) {
            increasingStack.pop();
            digitsRemoved++;
        }

        StringBuilder builder = new StringBuilder();

        while (!increasingStack.isEmpty()) {
            char digit = increasingStack.pop();
            builder.append(digit);
        }

        builder.reverse();

        StringBuilder result = new StringBuilder();
        boolean leadingDigit = false;
        for (int i = 0; i < builder.length(); i++) {
            if (!leadingDigit && builder.charAt(i) == '0') {
                continue;
            }
            leadingDigit = true;
            result.append(builder.charAt(i));
        }

        return result.isEmpty() ? "0" : result.toString();
    }
    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        System.out.println(removeKDigits.removeKDigits("10200", 1));
    }
}
