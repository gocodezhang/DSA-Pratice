import java.util.HashMap;
import java.util.Map;

public class FindDifference {
    public static char findTheDifference(String s, String t) {
        // create frequencyMap
        Map<Character, Integer> frequencyMap = new HashMap<>();
        // Iterate though S
        for (int i = 0; i < s.length(); i++) {
            // currLetter
            char currLetter = s.charAt(i);
            // frequency = frequencyMap.get(currLetter, 0)
            int frequency = frequencyMap.getOrDefault(currLetter, 0);
            frequency++;
            // frequencyMap.put(currLetter, frequency++)
            frequencyMap.put(currLetter, frequency);
        }

        // Iterate through T
        for (int i = 0; i < t.length(); i++) {
            // currLetter
            char currLetterT = t.charAt(i);
            // !frequencyMap.containKeys(currLetter) || frequencyMap.get(currLetter) == 0
            if (!frequencyMap.containsKey(currLetterT) || frequencyMap.get(currLetterT) == 0) {
                return currLetterT;
            }
            // frequency = frequencyMap.get(currLetter)
            int frequency = frequencyMap.get(currLetterT);
            frequency--;
            // frequencyMap.put(currLetter, frequency--)
            frequencyMap.put(currLetterT, frequency);
        }
        return ' ';
    }
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s, t));
    }
}
