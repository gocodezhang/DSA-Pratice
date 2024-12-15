import javax.swing.*;
import java.util.*;

public class PlayGround {
    static HashMap<Integer, Character> map = new HashMap<>();
    static {map.put(1, 'I');
    map.put(5, 'V');
    map.put(10, 'X');
    map.put(50, 'L');
    map.put(100, 'C');
    map.put(500, 'D');
    map.put(1000, 'M');}

    public String intToRoman(int num) {
        // put digits into stack
        Stack<Integer> stack = new Stack<>();
        while (num != 0) {
            int digit = num % 10;
            stack.push(digit);
            num = num / 10;
        }

        StringBuilder builder = new StringBuilder();
        // process the digits from the top
        while (!stack.isEmpty()) {
            int currDigit = stack.pop();
            int unit = (int) Math.pow(10, stack.size());
            // check if digit is 4 or 9
            if (currDigit == 4 || currDigit == 9) {
                // when true, upscale it and substract
                currDigit = currDigit + 1;
                builder.append(map.get(unit));
                builder.append(map.get(currDigit * unit));
            } else {
                // when false, find corresponding symbol
                if (currDigit >= 5) {
                    currDigit = currDigit - 5;
                    builder.append(map.get(5 * unit));
                }
                while (currDigit > 0) {
                    builder.append(map.get(unit));
                    currDigit--;
                }
            }
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        PlayGround playground = new PlayGround();
        System.out.println(playground.intToRoman(1994));
    }
}
