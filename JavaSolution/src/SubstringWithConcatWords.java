import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SubstringWithConcatWords {
    public List<Integer> findSubstring(String s, String[] words) {
        // windowSize = words[0].length * words.length
        int windowSize = words[0].length() * words.length;
        // result = []
        List<Integer> result = new ArrayList<>();

        for (int left = 0; left + windowSize <= s.length(); left++) {
            // validate currWindow
            if (validateWindow(left, words[0].length(), windowSize, s, words)) {
                // if valid, add left into result
                result.add(left);
            }
        }

        // return result
        return result;
    }
    public boolean validateWindow(int startingIndex, int wordSize, int windowSize, String s, String[] words) {
        System.out.println(startingIndex);
        String currWord = "";
        int endingIndex = startingIndex + windowSize;
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (String word: words) {
            int frequency = frequencyMap.getOrDefault(word, 0);
            frequencyMap.put(word, frequency + 1);
        }
        while (startingIndex < endingIndex) {
            currWord += s.charAt(startingIndex);
            if (currWord.length() == wordSize) {
                // check if currWord is not in words
                int currFrequency = frequencyMap.getOrDefault(currWord, 0);
                if (currFrequency == 0) {
                    return false;
                }
                frequencyMap.put(currWord, currFrequency - 1);
                currWord = "";
            }
            startingIndex++;
        }
        // return true
        return true;
    }
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        SubstringWithConcatWords substringWithConcatWords = new SubstringWithConcatWords();
        System.out.println(substringWithConcatWords.findSubstring(s, words));
    }
}
