import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> digits = new ArrayList<>();
        int num = x;

        while (num != 0) {
            int lastDigit = num % 10;
            digits.add(lastDigit);
            num = num / 10;
        }

        int left = 0;
        int right = digits.size() - 1;

        while (left < right) {
            if (digits.get(left) != digits.get(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
    public boolean isPalindromeOptimal(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        int num = x;
        int revertNum = 0;

        while (num > revertNum) {
            int digit = num % 10;
            revertNum = revertNum * 10 + digit;
            num = num / 10;
        }

        return num == revertNum || num == (revertNum / 10);
    }

    public static void main(String[] args) {
        int x = -121;
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(x));
    }
}
