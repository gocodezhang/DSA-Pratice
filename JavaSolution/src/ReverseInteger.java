public class ReverseInteger {
    public int reverse(int x) {
        int revert = 0;

        while (x != 0) {
            int digit = x % 10;
            long temp = (long) revert * 10 + digit;
            revert = revert * 10 + digit;

            if (temp != revert) {
                return 0;
            }
            x = x / 10;
        }

        return revert;
    }
    public int reverse32bitOnly(int x) {
        int revert = 0;

        while (x != 0) {
            int digit = x % 10;

            // check overflow +
            if (revert > Integer.MAX_VALUE / 10 || (revert == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            // check overflow -
            if (revert < Integer.MIN_VALUE / 10 || (revert == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            revert = revert * 10 + digit;
            x = x / 10;
        }

        return revert;
    }
}
