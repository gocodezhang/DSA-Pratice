import java.util.HashMap;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        // build a frequencyMap for magazine
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char letter = magazine.charAt(i);
            int currFrequency = frequencyMap.getOrDefault(letter, 0);
            currFrequency += 1;
            frequencyMap.put(letter, currFrequency);
        }
        // iterate through ransomNote and check if letter exist in the frequencyMap
        for (int i = 0; i < ransomNote.length(); i++) {
            char ransomLetter = ransomNote.charAt(i);
            int frequency = frequencyMap.getOrDefault(ransomLetter, 0);
            if (frequency == 0) {
                return false;
            }
            frequency -= 1;
            frequencyMap.put(ransomLetter, frequency);
        }
        return true;
    }
    public static void main(String[] args) {
        String ransomNote = "aac";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
