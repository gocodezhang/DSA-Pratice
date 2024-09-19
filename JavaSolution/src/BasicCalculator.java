import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculator {
    public int calculate(String s) {
        Deque<Object> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == ' ') {
                continue;
            }
            if (currChar == '-' || currChar == '+' || currChar == '(') {
                stack.push(currChar);
                continue;
            }
            if (Character.isDigit(currChar)) {
                int sum = currChar - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    sum = 10 * sum + (s.charAt(i + 1) - '0');
                    i++;
                }
                stack.push(sum);
                continue;
            }
            int sum = 0;
            while (!stack.isEmpty() && (stack.peek() instanceof Integer)) {
                int num = (int) stack.pop();
                char signChar = ((char) stack.peek()) != '(' ? (char) stack.pop() : '+';
                if (signChar == '-') {
                    sum += - num;
                } else {
                    sum += num;
                }
            }
            stack.pop();
            stack.push(sum);

        }

        int finalResult = 0;
        while (!stack.isEmpty()) {
            int num = (int) stack.pop();
            char signChar = !stack.isEmpty() ? (char) stack.pop() : '+';
            if (signChar == '+') {
                finalResult += num;
            }  else {
                finalResult += - num;
            }
        }
        return finalResult;
    }
    public static void main(String[] args) {
        String s = "1+(4 -5+2)";
        BasicCalculator basicCalculator = new BasicCalculator();
        System.out.println(basicCalculator.calculate(s));
    }
}
