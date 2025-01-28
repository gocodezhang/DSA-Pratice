public class StringToInteger {
    public int myAtoi(String s) {
        // 1. remove any leading white space
        int start = 0;
        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        };
        // 2. check their sign
        int sign = 1;
        if (start < s.length() && (s.charAt(start) == '+' || s.charAt(start) == '-')) {
            sign = s.charAt(start) == '+' ? 1 : -1;
            start++;
        }
        // 3. determine where we stop reading
        int end = start;
        while (end < s.length() && Character.isDigit(s.charAt(end))) {
            end++;
        }
        // 4. convert target substr and check overflow
        if (start >= end) {
            return 0;
        }

//        return rounding(s, start, end, sign);
        return roundingAlt(s, start, end, sign);
    }
    public int rounding(String s, int start, int end, int sign) {
//        System.out.println(start);
//        System.out.println(end);
        long result = 0;
        for (int i = end - 1; i >= start; i--) {
//            System.out.println(i);
            int digit = s.charAt(i) - '0';
            result += digit * Math.pow(10, (end - 1) - i);
        }
        if (result == (int) result) {
            return sign * (int) result;
        } else {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
    }
    public int roundingAlt(String s, int start, int end, int sign) {
        int result = 0;
        for (int i = start; i < end; i++) {
            int digit = s.charAt(i) - '0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
        }
        return sign * result;
    }
}
