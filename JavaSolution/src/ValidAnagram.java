import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // create frequencyMap<Char, Int>
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        // for (i = 0; i < s.length(); i++)
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            int currFrequency = frequencyMap.getOrDefault(currChar, 0);
            frequencyMap.put(currChar, currFrequency + 1);
        }

        // for (i = 0; i < t.length(); i++)
        for (int i = 0; i < t.length(); i++) {
            char currChar = t.charAt(i);
            if (!frequencyMap.containsKey(currChar) || frequencyMap.get(currChar) == 0) {
                return false;
            }
            int frequency = frequencyMap.get(currChar);

            frequencyMap.put(currChar, frequency - 1);
        }

        return true;
    }
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram(s, t));
    }
}
