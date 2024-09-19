import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class ValidParentheses {
    public boolean isValid(String s) {

        HashMap<Character, Character> rightParenthesesMap = new HashMap<>();
        rightParenthesesMap.put(')','(');
        rightParenthesesMap.put('}','{');
        rightParenthesesMap.put(']','[');
        HashSet<Character> leftParenthesesSet = new HashSet<>();
        leftParenthesesSet.add('(');
        leftParenthesesSet.add('{');
        leftParenthesesSet.add('[');

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (leftParenthesesSet.contains(currChar)) {
                stack.push(currChar);
                continue;
            }
            if (stack.isEmpty() || rightParenthesesMap.get(currChar) != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "([])";
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid(s));
    }
}
