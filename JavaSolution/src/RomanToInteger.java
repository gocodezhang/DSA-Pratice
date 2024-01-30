import java.util.HashMap;

public class RomanToInteger {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanLetterToNum = new HashMap<>();
        romanLetterToNum.put('I', 1);
        romanLetterToNum.put('V', 5);
        romanLetterToNum.put('X', 10);
        romanLetterToNum.put('L', 50);
        romanLetterToNum.put('C', 100);
        romanLetterToNum.put('D', 500);
        romanLetterToNum.put('M', 1000);
        //Create result, next, curr
        int result = 0;
        int next;
        int curr;
        //Iterate through the String
        for (int i = 0; i < s.length(); i++) {
            // curr = String[i]
            curr = romanLetterToNum.get(s.charAt(i));
            // next = i + 1 >= length ? infinity : String[i + 1]
            next = i + 1 >= s.length() ? Integer.MIN_VALUE : romanLetterToNum.get(s.charAt(i + 1));
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
        System.out.println(romanToInt(s));
    }
}
