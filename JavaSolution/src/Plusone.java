import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Plusone {
    public static int[] pluesOne(int[] digits) {
        // create resultArr with the length
        int[] tempArr = new int[digits.length + 1];
        // create carry = 0;
        int carry = 0;
        // traverse the origin array from the back
        for (int i = digits.length - 1; i >= 0; i--) {
            // check if it is last digit
            int sum;
            if (i == digits.length - 1) {
                // if yes, sum = originNum + 1 + carry
                sum = digits[i] + 1 + carry;
            } else {
                sum = digits[i] + carry;
            }
            // assign resultArr[i] = sum % 10;
            tempArr[i + 1] = sum % 10;
            // assign carry = sum / 10;
            carry = sum / 10;
        }

        int[] resultArr;
        // check if carry = 1
        if (carry == 1) {
            tempArr[0] = 1;
            resultArr = tempArr;
        } else {
            resultArr = Arrays.copyOfRange(tempArr, 1, tempArr.length);
        }

        // return resultArr
        return resultArr;

    }
    public static void main(String[] args) {
        int[] digits = {9,9,9};
        System.out.println(Arrays.toString(pluesOne(digits)));
    }
}
