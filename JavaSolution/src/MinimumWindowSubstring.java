import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        // build targetWindow
        HashMap<Character, Integer> targetWindow = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char currChar = t.charAt(i);
            int frequency = targetWindow.getOrDefault(currChar, 0);
            targetWindow.put(currChar, frequency + 1);
        }

        // start sliding window
        int left = 0;
        int right = 0;
        int countChar = 0;
        int minLeft = -1;
        int minRight = s.length() - 1;
        HashMap<Character, Integer> currWindow = new HashMap<>();

        while (right < s.length()) {
            char currChar = s.charAt(right);
            if (targetWindow.containsKey(currChar)) {
                currWindow.put(currChar, currWindow.getOrDefault(currChar, 0) + 1);
                // map store integer as object, hence we need to convert them into int before comparing
                if (currWindow.get(currChar).intValue() == targetWindow.get(currChar).intValue()) {
                    countChar++;
                }
            }
            while (countChar == targetWindow.size() && left <= right) {
                if ((right - left) < (minRight - minLeft)) {
                    minRight = right;
                    minLeft = left;
                }
                if (currWindow.containsKey(s.charAt(left))) {
                    currWindow.put(s.charAt(left), currWindow.get(s.charAt(left)) - 1);
                    if (currWindow.get(s.charAt(left)).intValue() < targetWindow.get(s.charAt(left)).intValue()) {
                        countChar--;
                    }
                }
                left++;
            }
            right++;
        }

        return minLeft == -1 ? "" : s.substring(minLeft, minRight + 1);
    }
    public static void main(String[] args) {
        String s = "AAAABC";
        String t = "ABC";

        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow(s, t));
    }
}
