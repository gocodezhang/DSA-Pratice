import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterComboOfPhoneNumber {
    Map<Character, String> digitToChars = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    public List<String> letterCombinations(String digits) {
        // create list - combo
        List<String> combo = new ArrayList<>();
        if (digits.length() == 0) {
            return combo;
        }
        // dfs
        dfs("", digits, combo);
        // return combo
        return combo;
    }
    public void dfs(String currCombo, String digits, List<String> combo) {
        // int i = currCombo.length
        int i = currCombo.length();
        // base case
        // if (i == digits.length)
        if (i == digits.length()) {
            combo.add(currCombo);
            return;
        }

        // recursive case
        // nextDigit = digits.charAt(i)
        char nextDigit = digits.charAt(i);
        // possibleLetters = map.get(nextDigit)
        // for (char letter of possibleLetters)
        String possibleLetters = digitToChars.get(nextDigit);
        for (int j = 0; j < possibleLetters.length(); j++) {
            char letter = possibleLetters.charAt(j);
            //dfs(currCombo + letter, digits, combo)
            dfs(currCombo + letter, digits, combo);
        }

    }
    public static void main(String[] args) {
        String digits = "23";
        LetterComboOfPhoneNumber letterComboOfPhoneNumber = new LetterComboOfPhoneNumber();
        System.out.println(letterComboOfPhoneNumber.letterCombinations(digits));
    }
}
