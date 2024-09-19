import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        // create a stack
        Deque<Integer> stack = new LinkedList<>();
        HashSet<String> operatorSet = new HashSet<>();
        operatorSet.add("+");
        operatorSet.add("-");
        operatorSet.add("*");
        operatorSet.add("/");
        // go through tokens
        for (int i = 0; i < tokens.length; i++) {
            String currToken = tokens[i];
            if (!operatorSet.contains(currToken)) {
                stack.push(Integer.parseInt(currToken));
                continue;
            }
            int secondOperand = stack.pop();
            int firstOperand = stack.pop();
            if (currToken.equals("+")) {
                stack.push(firstOperand + secondOperand);
            } else if (currToken.equals("-")) {
                stack.push(firstOperand - secondOperand);
            } else if (currToken.equals("*")) {
                stack.push(firstOperand * secondOperand);
            } else {
                boolean isPositive = firstOperand * secondOperand > 0;
                int result = isPositive ? (int) Math.floor(firstOperand / secondOperand) : (int) Math.ceil(firstOperand / secondOperand);
                stack.push(result);
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        System.out.println(evaluateReversePolishNotation.evalRPN(tokens));
    }

}
