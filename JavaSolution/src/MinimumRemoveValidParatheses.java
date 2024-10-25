import java.util.HashSet;
import java.util.Stack;

public class MinimumRemoveValidParatheses {
    public String minRemoveToMakeValid(String s) {
        // create stack
        Stack<Integer> indexStack = new Stack<>();
        // go through s
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == ')' && !indexStack.isEmpty() && s.charAt(indexStack.peek()) == '(') {
                indexStack.pop();
                continue;
            }
            // ( put into stack
            if (currChar == '(' || currChar == ')') {
                indexStack.add(i);
            }
        }
        HashSet<Integer> remove = new HashSet<>(indexStack);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!remove.contains(i)) {
                builder.append(s.charAt(i));
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        MinimumRemoveValidParatheses minimumRemoveValidParatheses = new MinimumRemoveValidParatheses();
        System.out.println(minimumRemoveValidParatheses.minRemoveToMakeValid(s));
    }

}
