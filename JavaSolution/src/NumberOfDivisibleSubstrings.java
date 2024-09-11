import java.util.HashMap;

public class NumberOfDivisibleSubstrings {
    public int countDivisibleSubstrings(String word) {
        int n = word.length();
        int counter = 0;
        // perform prefixSum operations n time
        for (int a = 1; a < 10; a++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += charToInt(word.charAt(i)) - a;
                int frequency = map.getOrDefault(sum, 0);
                counter += frequency;
                map.put(sum, frequency + 1);
            }
        }
        return counter;
    }
    private int charToInt(char currChar) {
        int diff = currChar - 'a';
        if (currChar != 'a' && currChar != 'b') {
            diff = diff + 1;
        }
        return diff / 3 + 1;
    }
    public static void main(String[] args) {
        String word = "asdf";
        NumberOfDivisibleSubstrings numberOfDivisibleSubstrings = new NumberOfDivisibleSubstrings();
        System.out.println(numberOfDivisibleSubstrings.countDivisibleSubstrings(word));
    }
}
