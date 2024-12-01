/**
 * A produce code is a sequence of digits represented by string.
 * Given an old product code, the challenge is to find the smallest new produce code
 * which is attractive and larger or equal to the old produce code
 *
 * Given an input integer K, A number is attractive if for each i such that 0 < i < n - k, num[i] = num[i + k]
 *
 * Example:
 * old_code = "1234", k = 2;
 * findMinimumCode(old_code, k) -> "1313"
 *
 * old_code = "41242", k = 4;
 * findMinimumCode(old_code, k) -> "41244"
 *
 */
public class AmazonFindMinimumAttCode {
    public String findMinimumCode(String old_code, int k) {
        // check if old code is attractive
        if (isAttractive(old_code, k)) {
            // return old code if it is attractive
            return old_code;
        }
        // build the next smallest attractive code

        // 1. find prefix
        String prefix = old_code.substring(0, k);
        // 2. check if it is smaller than old_code
        int index = 0;
        while (index < old_code.length() && prefix.charAt(index % k) >= old_code.charAt(index)) {
            index++;
        }
        // if new code is already large or equal, return new code directly
        if (index >= old_code.length()) {
            return buildCode(prefix, old_code.length());
        }

        // now we can either increase curr index by 1 or increase the index before by 1
        // we need to update the right most index
        int currIndex = index % k;
        int beforeIndex = (index - 1) % k;

        String updatePredix = updatePrefix(prefix, currIndex < beforeIndex ? beforeIndex : currIndex);

        return buildCode(updatePredix, old_code.length());

    }
    public boolean isAttractive(String s, int k) {
        int n = s.length();
        for (int i = 0; i < n - k; i++) {
            if (s.charAt(i) != s.charAt(i + k)) {
                return false;
            }
        }

        return true;
    }
    public String buildCode(String prefix, int n) {
        int k = prefix.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(prefix.charAt(i % k));
        }

        return builder.toString();
    }
    public String updatePrefix(String prefix, int index) {
        StringBuilder builder = new StringBuilder(prefix);

        int num = (builder.charAt(index) - '0') + 1;
        int digit = num % 10;
        int carry = num / 10;
        builder.setCharAt(index, (char) (digit + '0'));

        while (carry == 1) {
            index--;

            num = (builder.charAt(index) - '0') + 1;
            digit = num % 10;
            carry = num / 10;

            builder.setCharAt(index, (char) (digit + '0'));
        }

        return builder.toString();
    }
    public static void main(String[] args) {
        String s1 = "1212"; // 1212
        String s2 = "1234"; // 1313
        String s3 = "1989"; // 2020
        String s4 = "41242"; // 41244
        String s5 = "41245"; // 41254
        String s6 = "19998"; // 20002
        AmazonFindMinimumAttCode amazonFindMinimumAttCode = new AmazonFindMinimumAttCode();
        System.out.println(amazonFindMinimumAttCode.findMinimumCode(s1, 2));
        System.out.println(amazonFindMinimumAttCode.findMinimumCode(s2, 2));
        System.out.println(amazonFindMinimumAttCode.findMinimumCode(s3, 2));
        System.out.println(amazonFindMinimumAttCode.findMinimumCode(s4, 4));
        System.out.println(amazonFindMinimumAttCode.findMinimumCode(s5, 4));
        System.out.println(amazonFindMinimumAttCode.findMinimumCode(s6, 4));
    }


}
