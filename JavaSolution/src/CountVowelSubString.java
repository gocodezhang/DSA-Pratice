import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a string of lowercase letters in the range a-z,
 * determine the number of substrings that can be created where every letter is a vowel
 * and every vowel is present at least once. The vowels are ['a', 'e', 'i, 'o, 'u'].
 *
 * A substring is a contiguous group of characters in the string.
 *
 * Example
 * s = 'aeioaexaaeuiou'
 * There is a substring to the left that is made of vowels, 'aeioae' which is followed by an x' Since
 * 'x'is not a vowel, it cannot be included in the substring, and this substring does not contain all of the vowels. It is not a qualifying substring.
 * Moving to the right, there are four substrings that do qualify: 'aaeuiou', 'aaeuio', 'aeuiou' and 'aeuio.
 */
public class CountVowelSubString {
    static HashSet<Character> vowels = new HashSet<>();
    static {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }
    // three pointers one pass
    public int countVowelSubstringWhileLoop(String s) {
        // initalize a hashmap
        HashMap<Character, Integer> currWindow = new HashMap<>();
        // perform sliding window
        int result = 0;

        int numVowels = 0;
        int left = 0;
        int right = 0;
        int minLeft = 0;
        // while left is not at the end
        while (left < s.length()) {
            // contract the left end (til it is vowel)
            while (left < s.length() && !vowels.contains(s.charAt(left))) {
                left++;
            }


            right = left;
            minLeft = left;
            currWindow.clear();
            numVowels = 0;


            // expand the right end (til it is not a vowel)
            while (right < s.length() && vowels.contains(s.charAt(right))) {
                char currVowel = s.charAt(right);
                int frequency = currWindow.getOrDefault(currVowel, 0);
                currWindow.put(currVowel, frequency + 1);
                if (frequency == 0) {
                    numVowels++;
                }
                while (numVowels == 5) {
                    char leftVowel = s.charAt(minLeft);
                    currWindow.put(leftVowel, currWindow.get(leftVowel) - 1);
                    if (currWindow.get(leftVowel) == 0) {
                        numVowels--;
                    }
                    minLeft++;
                }
                result += (minLeft - left);
                right++;
            }

            left = right;

        }
        return result;
    }
    // three pointers one pass
    public int countVowelSubstringForLoop(String word) {
        HashMap<Character, Integer> currWindow = new HashMap<>();

        int result = 0;
        int minWindowLeft = 0;
        int left = 0;
        int countVowels = 0;

        for (int right = 0; right < word.length(); right++) {
            char currChar = word.charAt(right);
            if (vowels.contains(currChar)) {
                currWindow.put(currChar, currWindow.getOrDefault(currChar, 0) + 1);
                if (currWindow.get(currChar) == 1) {
                    countVowels++;
                }
                while (countVowels == 5) {
                    char minLeftChar = word.charAt(minWindowLeft);
                    currWindow.put(minLeftChar, currWindow.get(minLeftChar) - 1);
                    if (currWindow.get(minLeftChar) == 0) {
                        countVowels--;
                    }
                    minWindowLeft++;
                }
                result += (minWindowLeft - left);
            } else {
                left = right + 1;
                minWindowLeft = left;
                countVowels = 0;
                currWindow.clear();
            }
        }

        return result;
    }
    public int countVowelSubstringBF(String word) {
        int result = 0;
        int countVowels = 0;
        HashMap<Character, Integer> currWindow = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            if (vowels.contains(word.charAt(i))) {
                countVowels = 0;
                currWindow.clear();

                for (int j = i; j < word.length() && vowels.contains(word.charAt(j)); j++) {
                    char currChar = word.charAt(j);
                    currWindow.put(currChar, currWindow.getOrDefault(currChar, 0) + 1);
                    if (currWindow.get(currChar) == 1) {
                        countVowels++;
                    }
                    if (countVowels == 5) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "aeioaexaaeuiou";
        CountVowelSubString countVowelSubstring = new CountVowelSubString();
        System.out.println(countVowelSubstring.countVowelSubstringWhileLoop(s));
    }

}
