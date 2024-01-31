import java.util.HashMap;

public class IntegerToRoman {
    public static String intToRoman(int num) {
        int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String result = "";
        int index = 0;
        while (num > 0) {
            if (num - ints[index] >= 0) {
                num = num - ints[index];
                result = result + romans[index];
            } else {
                index++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
    }
}
