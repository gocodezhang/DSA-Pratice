import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubstrWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        // left = 0;
        int left = 0;
        // longestLength = 0
        int longestLength = 0;
        // hashSet
        HashSet<Character> set = new HashSet<>();
        // for (right = left; right < length; right++)
        for (int right = left; right < s.length(); right++) {
            char currChar = s.charAt(right);
            // if hashSet.has(currLetter)
            if (set.contains(currChar)) {
                // longestLength = max(longestLength, right - left)
                longestLength = Math.max(longestLength, right - left);
                // while (hashSet.has(currLetter)
                while (set.contains(currChar)) {
                    // hashSet.remove(str.charAt(left))
                    // left++
                    set.remove(s.charAt(left));
                    left += 1;
                }
            }

            // hashSet.add(str.charAt(right)
            set.add(currChar);
        }

        // return longestLength
        return Math.max(longestLength, s.length() - left);
    }
    public int lengthOfLongestSubstringOneIteration(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int longestLength = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char currChar = s.charAt(j);
            if (map.containsKey(currChar)) {
                int index = map.get(currChar);
                i = index < i ? i : index + 1;
            }
            map.put(currChar, j);
            longestLength = Math.max(j - i + 1, longestLength);
        }
        return longestLength;
    }
    public static void main(String args[]) {
        LongestSubstrWithoutRepeating longestSubstrWithoutRepeating = new LongestSubstrWithoutRepeating();
        String str = "tmmzuxt";
        System.out.println(longestSubstrWithoutRepeating.lengthOfLongestSubstringOneIteration(str));
    }

}
