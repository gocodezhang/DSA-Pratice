public class MultiplyString {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        int maxLength = num1.length() + num2.length();
        for (int i = 0; i < maxLength; i++) {
            result.append('0');
        }

        for (int index2 = num2.length() - 1; index2 >= 0; index2--) {
            for (int index1 = num1.length() - 1; index1 >= 0; index1--) {
                char digit2 = num2.charAt(index2);
                char digit1 = num1.charAt(index1);
                int currPos = index1 + index2 + 1;
                int mul = (digit1 - '0') * (digit2 - '0') + (result.charAt(currPos) - '0');
                result.setCharAt(currPos, (char) (mul % 10 + '0'));
                result.setCharAt(currPos - 1, (char) ((result.charAt(currPos - 1) - '0') + mul / 10 + '0'));
            }
        }
        while (result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.toString();

    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }
}
