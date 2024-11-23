import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        // remove all spaces
        String stringNoSpaces = s.replaceAll(" ", "");

        // find operands
        List<String> operands = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < stringNoSpaces.length(); i++) {
            if (!Character.isDigit(stringNoSpaces.charAt(i))) {
                String operand = stringNoSpaces.substring(start, i);
                operands.add(operand);
                start = i + 1;
            }
        }
        operands.add(stringNoSpaces.substring(start));

        Stack<Integer> stack = new Stack<>();
        int operandIndex = -1;
        for (int i = 0; i < operands.size(); i++) {
            String operand = operands.get(i);
            int curr = Integer.parseInt(operand);

            char operator = operandIndex == -1 ? '+' :stringNoSpaces.charAt(operandIndex);
            if (operator == '+' || operator == '-') {
                stack.push(operator == '+' ? curr : (-curr));
            } else if (operator == '*') {
                int left = stack.pop();
                stack.push(left * curr);
            } else {
                int left = stack.pop();
                stack.push(left / curr);
            }
            operandIndex += operand.length() + 1;

        }

        // go through stack and add / sub num in order
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        // return result

        return result;
    }
    public int calculateOnePass(String s) {
        Stack<Integer> stack = new Stack<>();

        int currNum = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (Character.isDigit(currChar)) {
                currNum = currNum * 10 + (currChar - '0');
            }
            if ((!Character.isWhitespace(currChar) && !Character.isDigit(currChar)) || i == s.length() - 1) {
                if (operator == '+') {
                    stack.push(currNum);
                } else if (operator == '-') {
                    stack.push(-currNum);
                } else if (operator == '*') {
                    int left = stack.pop();
                    stack.push(left * currNum);
                } else {
                    int left = stack.pop();
                    stack.push(left / currNum);
                }
                operator = currChar;
                currNum = 0;
            }

        }
        int result = currNum;
        for (int num : stack) {
            result += num;
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "3/2";
        BasicCalculatorII basicCalculatorII = new BasicCalculatorII();
        System.out.println(basicCalculatorII.calculateOnePass(s));
    }
}
