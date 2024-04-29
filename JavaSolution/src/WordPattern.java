import java.util.HashMap;

public class WordPattern {
    public boolean verifyPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        HashMap<String, Character> wordToPattern = new HashMap<>();
        HashMap<Character, String> patternToWord = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char pat = pattern.charAt(i);
            String word = words[i];
            if (!patternToWord.containsKey(pat)) {
                if (wordToPattern.containsKey(word)) {
                    return false;
                } else {
                    patternToWord.put(pat, word);
                    wordToPattern.put(word, pat);
                }
            } else {
                if (!patternToWord.get(pat).equals(word)) {
                    return false;
                }
            }

        }
        return true;
    }
    public static void main(String[] args) {
        String pattern = "abba", s = "dog dog dog dog";
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.verifyPattern(pattern, s));
    }
}
