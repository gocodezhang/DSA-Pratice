public class PlayGround {
    public static void  funcSubstring(String inputStr)
    {
        // Write your code here
        String result = "";
        for (int start = 0; start < inputStr.length(); start++) {
            for (int end = start + 1; end < inputStr.length(); end++) {
                if (isPalidrome(inputStr, start, end)) {
                    String currPalidrome = inputStr.substring(start, end + 1);
                    if (result.length() < currPalidrome.length() || result.compareTo(currPalidrome) < 0) {
                        result = currPalidrome;
                    }
                }
            }
        }
        System.out.println(result);


    }

    // Add a helper function
    public static boolean isPalidrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start += 1;
            end -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('1' * '2');
    }
}
