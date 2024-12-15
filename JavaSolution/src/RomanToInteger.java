import java.util.HashMap;
import java.util.Stack;

public class RomanToInteger {
    static HashMap<Character, Integer> map = new HashMap<>();
    static {map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);}

    public int romanToIntWithStack(String s) {
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (!stack.isEmpty() && map.get(currChar) > map.get(stack.peek())) {
                char prev = stack.pop();
                result += map.get(currChar) - map.get(prev);
            } else {
                stack.add(currChar);
            }
        }

        for (char letter : stack) {
            result += map.get(letter);
        }

        return result;
    }
    public int romanToInt(String s) {
        //Create result, next, curr
        int result = 0;
        int next;
        int curr;
        //Iterate through the String
        for (int i = 0; i < s.length(); i++) {
            // curr = String[i]
            curr = map.get(s.charAt(i));
            // next = i + 1 >= length ? infinity : String[i + 1]
            next = i + 1 >= s.length() ? Integer.MIN_VALUE : map.get(s.charAt(i + 1));
            // check if curr < next
            if (curr < next) {
                // result = result - curr
                result -= curr;
            } else {
                // otherwise
                // result = result + curr
                result += curr;
            }
        }


        // return result
        return result;
    }
    public static void main(String[] args) {
        String s = "MCMXCIV";
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToIntWithStack(s));
    }
}
