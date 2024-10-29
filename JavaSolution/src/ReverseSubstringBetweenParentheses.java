import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseSubstringBetweenParentheses {
    public String reverseParentheses(String s) {
        // use a stack to identify parentheses
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar != ')') {
                stack.add(currChar);
                continue;
            }
            // whenever encounter ), find all letter til (
            List<Character> tempList = new ArrayList<>();
            while (!stack.isEmpty() && stack.peek() != '(') {
                tempList.add(stack.pop());
            }
            stack.pop();
            // reverse it and push it back into the stack
            for (int j = 0; j < tempList.size(); j++) {
                stack.add(tempList.get(j));
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char currChar : stack) {
            builder.append(currChar);
        }

        return builder.toString();
    }

}
