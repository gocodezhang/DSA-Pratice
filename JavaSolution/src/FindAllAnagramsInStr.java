import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInStr {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) {
            return result;
        }

        HashMap<Character, Integer> targetWindow = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char currChar = p.charAt(i);
            targetWindow.put(currChar, targetWindow.getOrDefault(currChar, 0) + 1);
        }
        HashMap<Character, Integer> currWindow = new HashMap<>();
        int countChar = 0;
        for (int i = 0; i < p.length() - 1; i++) {
            char currChar = s.charAt(i);
            if (targetWindow.containsKey(currChar)) {
                currWindow.put(currChar, currWindow.getOrDefault(currChar, 0) + 1);
                if (currWindow.get(currChar).intValue() == targetWindow.get(currChar).intValue()) {
                    countChar++;
                }
            }
        }
        int right = p.length() - 1;
        int left = 0;
        while (right < s.length()) {
            if (targetWindow.containsKey(s.charAt(right))) {
                currWindow.put(s.charAt(right), currWindow.getOrDefault(s.charAt(right), 0) + 1);
                if (currWindow.get(s.charAt(right)).intValue() == targetWindow.get(s.charAt(right)).intValue()) {
                    countChar++;
                }
            }
            if (countChar == targetWindow.size()) {
                result.add(left);
            }
            if (currWindow.containsKey(s.charAt(left))) {
                currWindow.put(s.charAt(left), currWindow.get(s.charAt(left)) - 1);
                if (currWindow.get(s.charAt(left)) + 1 == targetWindow.get(s.charAt(left))) {
                    countChar--;
                }
            }
            left++;
            right++;
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        FindAllAnagramsInStr findAllAnagramsInStr = new FindAllAnagramsInStr();
        System.out.println(findAllAnagramsInStr.findAnagrams(s, p));
    }

}
