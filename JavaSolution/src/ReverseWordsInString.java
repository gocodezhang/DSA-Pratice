import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        // wordsWithSpaces = s.split(' ')
        String[] wordsWithSpaces = s.split(" ");
        // result = ""
        String result = "";
        // for (i = size - 1; i >= 0; i--)
        for (int i = wordsWithSpaces.length - 1; i >= 0; i--) {
            // trim(word)
            String wordWithSpace = wordsWithSpaces[i];
            if (wordWithSpace.length() == 0) {
                continue;
            }
            result += wordWithSpace.trim() + " ";
        }


        // return result
        return result.trim();
    }
    public String reverseWordsTwoPointers(String s) {
        List<String> words = new ArrayList<>();
        // lastIndex
        int lastIndexOfWord = -1;
        // go through string from the back
        for (int i = s.length() - 1; i >= -1; i--) {
            char curr = i == -1 ? ' ' : s.charAt(i);
            if (curr == ' ') {
                // when it is a space - check lastIndex is valid, add string from i + 1, lastIndex
                if (lastIndexOfWord != -1) {
                    words.add(s.substring(i + 1, lastIndexOfWord + 1));
                    lastIndexOfWord = -1;
                }
            } else {
                // when it is not a space - update lastIndex if lastIndex is not valid
                if (lastIndexOfWord == -1) {
                    lastIndexOfWord = i;
                }
            }
        }

        return String.join(" ", words);
    }
    public static void main(String[] args) {
        String s = "  hello world  ";
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        System.out.println(reverseWordsInString.reverseWords(s));
    }
}
