public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        // remove all non-alphanumeric characters
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        // convert to lower cases
        s = s.toLowerCase();
        // valid if it is palindrome
        if (s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
