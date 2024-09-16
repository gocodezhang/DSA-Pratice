import java.util.HashMap;

public class PermutationInString {
    public boolean checkInInclusion(String s1, String s2) {
        // build permutation representation of s1 (hashmap)
        HashMap<Character, Integer> targetWindow = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char currChar = s1.charAt(i);
            targetWindow.put(currChar, targetWindow.getOrDefault(currChar, 0) + 1);
        }

        // perform sliding window
        // create currWindow, charCount, left and right
        HashMap<Character, Integer> currWindow = new HashMap<>();
        int left = 0;
        int right = 0;
        int charCount = 0;
        boolean excess = false;

        while (right < s2.length()) {
            // keep moving left til char at left contains in targetWindow
            while (left < s2.length() && excess) {
                char currLeftChar = s2.charAt(left);
                currWindow.put(currLeftChar, currWindow.get(currLeftChar) - 1);
                if (currWindow.get(currLeftChar).intValue() == targetWindow.get(currLeftChar).intValue()) {
                    excess = false;
                }
                if (currWindow.get(currLeftChar).intValue() + 1 == targetWindow.get(currLeftChar).intValue()) {
                    charCount--;
                }
                left++;
            }
            // keep moving right til chat is not in targetWindow
            char currRightChar = s2.charAt(right);
            int currFrequency = currWindow.getOrDefault(currRightChar, 0);
            if (!targetWindow.containsKey(currRightChar)) {
                currWindow.clear();
                excess = false;
                charCount = 0;
                left = right + 1;
            } else {
                currWindow.put(currRightChar, currFrequency + 1);
                if (currFrequency + 1 == targetWindow.get(currRightChar)) {
                    charCount++;
                    if (charCount == targetWindow.size()) {
                        return true;
                    }
                } else if (currFrequency + 1 > targetWindow.get(currRightChar)) {
                    excess = true;
                }
            }
            right++;

        }
        return false;
    }
    public boolean checkInConclusionEasyImplementation(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int subStrLength = s1.length();
        HashMap<Character, Integer> targetWindow = new HashMap<>();
        HashMap<Character, Integer> currWindow = new HashMap<>();
        int countChar = 0;
        for (int i = 0; i < subStrLength; i++) {
            char targetChar = s1.charAt(i);
            targetWindow.put(targetChar, targetWindow.getOrDefault(targetChar, 0) + 1);
        }
        for (int i = 0; i < subStrLength; i++) {
            char currChar = s2.charAt(i);
            if (targetWindow.containsKey(currChar)) {
                int frequency = currWindow.getOrDefault(currChar, 0);
                currWindow.put(currChar, frequency + 1);
                if (frequency + 1 == targetWindow.get(currChar)) {
                    countChar++;
                }
            }
        }
        int left = 0;
        int right = subStrLength - 1;

        while (right < s2.length()) {
            if (countChar == targetWindow.size()) {
                return true;
            }
            right++;
            if (right < s2.length() && targetWindow.containsKey(s2.charAt(right))) {
                currWindow.put(s2.charAt(right), currWindow.getOrDefault(s2.charAt(right), 0) + 1);
                if (currWindow.get(s2.charAt(right)).intValue() == targetWindow.get(s2.charAt(right)).intValue()) {
                    countChar++;
                }
            }
            char leftChar = s2.charAt(left);
            if (currWindow.containsKey(leftChar)) {
                currWindow.put(leftChar, currWindow.get(leftChar) - 1);
                if (currWindow.get(leftChar) + 1 == targetWindow.get(leftChar)) {
                    countChar--;
                }
            }
            left++;
        }
        return false;
    }
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.checkInConclusionEasyImplementation(s1, s2));
    }
}
