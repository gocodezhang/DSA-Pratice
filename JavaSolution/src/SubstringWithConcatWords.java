import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SubstringWithConcatWords {
    private HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
    private int n;
    private int wordLength;
    private int substringSize;
    private int k;
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
    public List<Integer> findSubstringOptimal(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        n = s.length();
        wordLength = words[0].length();
        k = words.length;
        substringSize = wordLength * k;

        for (int i = 0; i < k; i++) {
            String word = words[i];
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            slidingWindow(i, s, result);
        }

        return result;
    }
    public void slidingWindow(int left, String s, List<Integer> result) {
        HashMap<String, Integer> wordFound = new HashMap<>();
        boolean excessWord = false;
        int wordUsed = 0;

        for (int right = left; right <= n - wordLength; right += wordLength) {
            String currWord = s.substring(right, right + wordLength);
            if (!wordCount.containsKey(currWord)) {
                left = right + wordLength;
                excessWord = false;
                wordFound.clear();
                wordUsed = 0;
            } else {
                while (right - left == substringSize || excessWord) {
                    String leftMostWord = s.substring(left, left + wordLength);
                    left = left + wordLength;
                    wordFound.put(leftMostWord, wordFound.get(leftMostWord) - 1);
                    if (wordFound.get(leftMostWord) >= wordCount.get(leftMostWord)) {
                        excessWord = false;
                    }
                    wordUsed--;
                }
                wordFound.put(currWord, wordFound.getOrDefault(currWord, 0) + 1);
                wordUsed++;
                if (wordFound.get(currWord) > wordCount.get(currWord)) {
                    excessWord = true;
                }
                if (wordUsed == k && !excessWord) {
                    result.add(left);
                }
            }
        }
    }
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        SubstringWithConcatWords substringWithConcatWords = new SubstringWithConcatWords();
        System.out.println(substringWithConcatWords.findSubstringOptimal(s, words));
    }
}
